/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  javax.vecmath.Matrix4f
 *  javax.vecmath.Vector2f
 *  javax.vecmath.Vector3f
 *  org.apache.commons.lang3.ArrayUtils
 */
package mchorse.emoticons.skin_n_bones.api.bobj;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.vecmath.Matrix4f;
import javax.vecmath.Vector2f;
import javax.vecmath.Vector3f;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJAction;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJArmature;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJBone;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJBoneModifier;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJChannel;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJGroup;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJKeyframe;
import org.apache.commons.lang3.ArrayUtils;

public class BOBJLoader {
    public static void merge(BOBJData bOBJData, BOBJData bOBJData2) {
        int n = bOBJData.vertices.size();
        int n2 = bOBJData.normals.size();
        int n3 = bOBJData.textures.size();
        bOBJData.vertices.addAll(bOBJData2.vertices);
        bOBJData.normals.addAll(bOBJData2.normals);
        bOBJData.textures.addAll(bOBJData2.textures);
        for (BOBJMesh bOBJMesh : bOBJData2.meshes) {
            BOBJMesh bOBJMesh2 = bOBJMesh.add(n, n2, n3);
            bOBJMesh2.armature = (BOBJArmature)bOBJData.armatures.get(bOBJMesh2.armatureName);
            bOBJData.meshes.add(bOBJMesh2);
        }
    }

    public static List readAllLines(InputStream inputStream) {
        ArrayList<String> arrayList = new ArrayList<String>();
        try {
            String string;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while ((string = bufferedReader.readLine()) != null) {
                arrayList.add(string);
            }
            bufferedReader.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return arrayList;
    }

    public static BOBJData readData(InputStream inputStream) {
        List list = BOBJLoader.readAllLines(inputStream);
        ArrayList<Vertex> arrayList = new ArrayList<Vertex>();
        ArrayList<Vector2f> arrayList2 = new ArrayList<Vector2f>();
        ArrayList<Vector3f> arrayList3 = new ArrayList<Vector3f>();
        ArrayList<BOBJMesh> arrayList4 = new ArrayList<BOBJMesh>();
        HashMap<String, BOBJAction> hashMap = new HashMap<String, BOBJAction>();
        HashMap<String, BOBJArmature> hashMap2 = new HashMap<String, BOBJArmature>();
        BOBJMesh bOBJMesh = null;
        BOBJAction bOBJAction = null;
        BOBJGroup bOBJGroup = null;
        BOBJChannel bOBJChannel = null;
        BOBJArmature bOBJArmature = null;
        BOBJBone bOBJBone = null;
        Vertex vertex = null;
        int n = 0;
        for (String string : list) {
            String[] arrstring = string.split("\\s");
            String string2 = arrstring[0];
            if (string2.equals("o")) {
                bOBJMesh = new BOBJMesh(arrstring[1]);
                arrayList4.add(bOBJMesh);
                bOBJArmature = null;
                vertex = null;
                continue;
            }
            if (string2.equals("o_arm")) {
                bOBJMesh.armatureName = arrstring[1];
                continue;
            }
            if (string2.equals("v")) {
                if (vertex != null) {
                    vertex.eliminateTinyWeights();
                }
                vertex = new Vertex(Float.parseFloat(arrstring[1]), Float.parseFloat(arrstring[2]), Float.parseFloat(arrstring[3]));
                arrayList.add(vertex);
                continue;
            }
            if (string2.equals("vw")) {
                float f = Float.parseFloat(arrstring[2]);
                if (f == 0.0f) continue;
                vertex.weights.add(new Weight(arrstring[1], f));
                continue;
            }
            if (string2.equals("vt")) {
                arrayList2.add(new Vector2f(Float.parseFloat(arrstring[1]), Float.parseFloat(arrstring[2])));
                continue;
            }
            if (string2.equals("vn")) {
                arrayList3.add(new Vector3f(Float.parseFloat(arrstring[1]), Float.parseFloat(arrstring[2]), Float.parseFloat(arrstring[3])));
                continue;
            }
            if (string2.equals("f")) {
                bOBJMesh.faces.add(new Face(arrstring[1], arrstring[2], arrstring[3]));
                continue;
            }
            if (string2.equals("arm_name")) {
                n = 0;
                bOBJBone = null;
                bOBJArmature = new BOBJArmature(arrstring[1]);
                hashMap2.put(bOBJArmature.name, bOBJArmature);
                continue;
            }
            if (string2.equals("arm_action")) {
                bOBJArmature.action = arrstring[1];
                continue;
            }
            if (string2.equals("arm_bone")) {
                Vector3f vector3f = new Vector3f(Float.parseFloat(arrstring[3]), Float.parseFloat(arrstring[4]), Float.parseFloat(arrstring[5]));
                Matrix4f matrix4f = new Matrix4f();
                float[] arrf = new float[16];
                for (int i = 6; i < 22; ++i) {
                    arrf[i - 6] = Float.parseFloat(arrstring[i]);
                }
                matrix4f.set(arrf);
                bOBJBone = new BOBJBone(n++, arrstring[1], arrstring[2], vector3f, matrix4f);
                bOBJArmature.addBone(bOBJBone);
                continue;
            }
            if (string2.equals("arm_ik") && arrstring.length >= 2) {
                BOBJBone bOBJBone2 = (BOBJBone)bOBJArmature.bones.get(arrstring[1]);
                if (bOBJBone == null) {
                    System.out.println("Found IK modifier in BOBJ, but bone " + arrstring[1] + " doesn't exist...");
                    continue;
                }
                int n2 = arrstring.length >= 3 ? Integer.parseInt(arrstring[2]) : 1;
                boolean bl = arrstring.length >= 4 ? arrstring[3].equals("true") : false;
                bOBJBone.addModifier(new BOBJBoneModifier(bOBJBone2, n2, bl));
                continue;
            }
            if (string2.equals("an")) {
                bOBJAction = new BOBJAction(arrstring[1]);
                hashMap.put(arrstring[1], bOBJAction);
                continue;
            }
            if (string2.equals("ao")) {
                bOBJGroup = new BOBJGroup(arrstring[1]);
                bOBJAction.groups.put(arrstring[1], bOBJGroup);
                continue;
            }
            if (string2.equals("ag")) {
                bOBJChannel = new BOBJChannel(arrstring[1], Integer.parseInt(arrstring[2]));
                bOBJGroup.channels.add(bOBJChannel);
                continue;
            }
            if (!string2.equals("kf")) continue;
            bOBJChannel.keyframes.add(BOBJKeyframe.parse(arrstring));
        }
        if (vertex != null) {
            vertex.eliminateTinyWeights();
        }
        return new BOBJData(arrayList, arrayList2, arrayList3, arrayList4, hashMap, hashMap2);
    }

    public static Map loadMeshes(BOBJData bOBJData) {
        HashMap<String, CompiledData> hashMap = new HashMap<String, CompiledData>();
        for (BOBJMesh bOBJMesh : bOBJData.meshes) {
            Object object2;
            ArrayList arrayList = new ArrayList();
            List list = bOBJMesh.faces;
            int[] arrn = new int[list.size() * 3 * 4];
            float[] arrf = new float[list.size() * 3 * 4];
            float[] arrf2 = new float[list.size() * 3 * 4];
            float[] arrf3 = new float[list.size() * 3 * 2];
            float[] arrf4 = new float[list.size() * 3 * 3];
            Arrays.fill(arrn, -1);
            Arrays.fill(arrf, -1.0f);
            int n = 0;
            for (Object object2 : list) {
                for (IndexGroup indexGroup : ((Face)object2).idxGroups) {
                    BOBJLoader.processFaceVertex(n, indexGroup, bOBJMesh, bOBJData, arrayList, arrf2, arrf3, arrf4, arrf, arrn);
                    ++n;
                }
            }
            Integer[] arrinteger = arrayList.toArray(new Integer[0]);
            object2 = ArrayUtils.toPrimitive((Integer[])arrinteger);
            hashMap.put(bOBJMesh.name, new CompiledData(arrf2, arrf3, arrf4, arrf, arrn, (int[])object2, bOBJMesh));
        }
        return hashMap;
    }

    public static CompiledData loadMesh(BOBJData bOBJData) {
        Object object4;
        Object object22;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object object22 : bOBJData.meshes) {
            arrayList2.addAll(((BOBJMesh)object22).faces);
        }
        Object object3 = new float[arrayList2.size() * 3 * 4];
        object22 = new float[arrayList2.size() * 3 * 2];
        float[] arrf = new float[arrayList2.size() * 3 * 3];
        int n = 0;
        for (Object object4 : arrayList2) {
            for (IndexGroup indexGroup : ((Face)object4).idxGroups) {
                BOBJLoader.processFaceVertex(n, indexGroup, null, bOBJData, arrayList, (float[])object3, (float[])object22, arrf, null, null);
                ++n;
            }
        }
        Integer[] arrinteger = arrayList.toArray(new Integer[0]);
        object4 = ArrayUtils.toPrimitive((Integer[])arrinteger);
        return new CompiledData((float[])object3, (float[])object22, arrf, null, null, (int[])object4, null);
    }

    public static void processFaceVertex(int n, IndexGroup indexGroup, BOBJMesh bOBJMesh, BOBJData bOBJData, List list, float[] arrf, float[] arrf2, float[] arrf3, float[] arrf4, int[] arrn) {
        Vertex vertex;
        list.add(n);
        if (indexGroup.idxPos >= 0) {
            vertex = (Vertex)bOBJData.vertices.get(indexGroup.idxPos);
            arrf[n * 4] = vertex.x;
            arrf[n * 4 + 1] = vertex.y;
            arrf[n * 4 + 2] = vertex.z;
            arrf[n * 4 + 3] = 1.0f;
            if (bOBJMesh != null) {
                int n2 = Math.min(vertex.weights.size(), 4);
                for (int i = 0; i < n2; ++i) {
                    Weight weight = (Weight)vertex.weights.get(i);
                    BOBJBone bOBJBone = (BOBJBone)bOBJMesh.armature.bones.get(weight.name);
                    arrf4[n * 4 + i] = bOBJBone == null ? 0.0f : weight.factor;
                    arrn[n * 4 + i] = bOBJBone == null ? -1 : bOBJBone.index;
                }
            }
        }
        if (indexGroup.idxTextCoord >= 0) {
            vertex = (Vector2f)bOBJData.textures.get(indexGroup.idxTextCoord);
            arrf2[n * 2] = ((Vector2f)vertex).x;
            arrf2[n * 2 + 1] = 1.0f - ((Vector2f)vertex).y;
        }
        if (indexGroup.idxVecNormal >= 0) {
            vertex = (Vector3f)bOBJData.normals.get(indexGroup.idxVecNormal);
            arrf3[n * 3] = ((Vector3f)vertex).x;
            arrf3[n * 3 + 1] = ((Vector3f)vertex).y;
            arrf3[n * 3 + 2] = ((Vector3f)vertex).z;
        }
    }

    public static class CompiledData {
        public float[] posData;
        public float[] texData;
        public float[] normData;
        public float[] weightData;
        public int[] boneIndexData;
        public int[] indexData;
        public BOBJMesh mesh;

        public CompiledData(float[] arrf, float[] arrf2, float[] arrf3, float[] arrf4, int[] arrn, int[] arrn2, BOBJMesh bOBJMesh) {
            this.posData = arrf;
            this.texData = arrf2;
            this.normData = arrf3;
            this.weightData = arrf4;
            this.boneIndexData = arrn;
            this.indexData = arrn2;
            this.mesh = bOBJMesh;
        }
    }

    public static class BOBJData {
        public List vertices;
        public List textures;
        public List normals;
        public List meshes;
        public Map actions;
        public Map armatures;

        public BOBJData(List list, List list2, List list3, List list4, Map map, Map map2) {
            this.vertices = list;
            this.textures = list2;
            this.normals = list3;
            this.meshes = list4;
            this.actions = map;
            this.armatures = map2;
            for (BOBJMesh bOBJMesh : list4) {
                bOBJMesh.armature = (BOBJArmature)map2.get(bOBJMesh.armatureName);
            }
        }

        public boolean hasGeometry() {
            return !this.meshes.isEmpty();
        }

        public void dispose() {
            this.vertices.clear();
            this.textures.clear();
            this.normals.clear();
            this.meshes.clear();
        }
    }

    public static class Weight {
        public String name;
        public float factor;

        public Weight(String string, float f) {
            this.name = string;
            this.factor = f;
        }
    }

    public static class Vertex {
        public float x;
        public float y;
        public float z;
        public List weights = new ArrayList();

        public Vertex(float f, float f2, float f3) {
            this.x = f;
            this.y = f2;
            this.z = f3;
        }

        public void eliminateTinyWeights() {
            Iterator iterator = this.weights.iterator();
            while (iterator.hasNext()) {
                Weight weight = (Weight)iterator.next();
                if (!((double)weight.factor < 0.05)) continue;
                iterator.remove();
            }
            if (this.weights.size() > 0) {
                float f = 0.0f;
                for (Weight weight : this.weights) {
                    f += weight.factor;
                }
                if (f < 1.0f) {
                    ((Weight)this.weights.get((int)(this.weights.size() - 1))).factor += 1.0f - f;
                }
            }
        }
    }

    public static class IndexGroup {
        public static final int NO_VALUE = -1;
        public int idxPos = -1;
        public int idxTextCoord = -1;
        public int idxVecNormal = -1;

        public IndexGroup(int n, int n2, int n3) {
            this.idxPos = n;
            this.idxTextCoord = n2;
            this.idxVecNormal = n3;
        }

        public IndexGroup() {
        }
    }

    public static class Face {
        public IndexGroup[] idxGroups = new IndexGroup[3];

        public Face(String string, String string2, String string3) {
            this.idxGroups[0] = this.parseLine(string);
            this.idxGroups[1] = this.parseLine(string2);
            this.idxGroups[2] = this.parseLine(string3);
        }

        public Face() {
        }

        public IndexGroup parseLine(String string) {
            IndexGroup indexGroup = new IndexGroup();
            String[] arrstring = string.split("/");
            int n = arrstring.length;
            indexGroup.idxPos = Integer.parseInt(arrstring[0]) - 1;
            if (n > 1) {
                String string2 = arrstring[1];
                if (!string2.isEmpty()) {
                    indexGroup.idxTextCoord = Integer.parseInt(string2) - 1;
                }
                if (n > 2) {
                    indexGroup.idxVecNormal = Integer.parseInt(arrstring[2]) - 1;
                }
            }
            return indexGroup;
        }

        public Face add(int n, int n2, int n3) {
            Face face = new Face();
            for (int i = 0; i < face.idxGroups.length; ++i) {
                IndexGroup indexGroup = this.idxGroups[i];
                face.idxGroups[i] = new IndexGroup(indexGroup.idxPos + n, indexGroup.idxTextCoord + n3, indexGroup.idxVecNormal + n2);
            }
            return face;
        }
    }

    public static class BOBJMesh {
        public String name;
        public List faces = new ArrayList();
        public String armatureName;
        public BOBJArmature armature;

        public BOBJMesh(String string) {
            this.name = string;
        }

        public BOBJMesh add(int n, int n2, int n3) {
            BOBJMesh bOBJMesh = new BOBJMesh(this.name);
            bOBJMesh.armatureName = this.armatureName;
            bOBJMesh.armature = this.armature;
            for (Face face : this.faces) {
                bOBJMesh.faces.add(face.add(n, n2, n3));
            }
            return bOBJMesh;
        }
    }
}

