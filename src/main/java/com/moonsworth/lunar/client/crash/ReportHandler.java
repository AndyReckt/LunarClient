package com.moonsworth.lunar.client.crash;

import com.google.common.io.ByteStreams;
import com.google.gson.annotations.SerializedName;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.crash.CrashReportBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.feature.Feature;
import com.moonsworth.lunar.client.ref.Ref;

import javax.swing.*;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

public class ReportHandler {
    public static final String lIlIlIlIlIIlIIlIIllIIIIIl = "https://api.lunarclientprod.com/game/crashReport";
    public static final String IlllIIIIIIlllIlIIlllIlIIl = "https://api.lunarclientprod.com/game/bugReport";

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(String string, String string2) {
        String string4 = "BUG-" + UUID.randomUUID();
        ClientContext clientContext = ReportHandler.lIlIlIlIlIIlIIlIIllIIIIIl();
        String string5 = LunarClient.llIIlIlIIIllIlIlIlIIlIIll.toJson((Object)new lIlIlIlIlIIlIIlIIllIIIIIl(string4, string, string2, clientContext));
        Ref.IlllIIIIIIlllIlIIlllIlIIl().authenticate(string3 -> {
            try {
                Object object;
                URL uRL = new URL(IlllIIIIIIlllIlIIlllIlIIl);
                HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
                httpURLConnection.setRequestMethod("POST");
                if (string3 != null) {
                    httpURLConnection.setRequestProperty("Authorization", (String)string3);
                }
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(string5.length()));
                httpURLConnection.setDoOutput(true);
                httpURLConnection.connect();
                httpURLConnection.getOutputStream().write(string5.getBytes());
                httpURLConnection.getOutputStream().flush();
                int n = httpURLConnection.getResponseCode();
                System.out.println("responseCode = " + n);
                InputStream inputStream = httpURLConnection.getErrorStream();
                if (inputStream != null) {
                    object = new String(ByteStreams.toByteArray(inputStream));
                    System.err.println((String)object);
                } else {
                    System.err.println("error stream is null lol");
                }
                object = httpURLConnection.getInputStream();
                ((InputStream)object).close();
                httpURLConnection.disconnect();
                Ref.lIlIlIlIlIIlIIlIIllIIIIIl(new llIlllIIIllllIIlllIllIIIl(string4));
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(CrashReportBridge crashReportBridge) {
        System.out.println("HANDLING CRASH REPORT " + crashReportBridge.bridge$getTitle());
        String string = "CRASH-" + UUID.randomUUID();
        System.out.println(string);
        ClientContext clientContext = ReportHandler.lIlIlIlIlIIlIIlIIllIIIIIl();
        String string3 = LunarClient.llIIlIlIIIllIlIlIlIIlIIll.toJson((Object)new IlllIIIIIIlllIlIIlllIlIIl(string, crashReportBridge, clientContext));
        System.out.println(string3);
        Ref.IlllIIIIIIlllIlIIlllIlIIl().authenticate(string2 -> {
            try {
                Object object;
                URL uRL = new URL(lIlIlIlIlIIlIIlIIllIIIIIl);
                HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
                httpURLConnection.setRequestMethod("POST");
                if (string2 != null) {
                    httpURLConnection.setRequestProperty("Authorization", (String)string2);
                }
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(string3.length()));
                httpURLConnection.setDoOutput(true);
                httpURLConnection.connect();
                httpURLConnection.getOutputStream().write(string3.getBytes());
                httpURLConnection.getOutputStream().flush();
                int n = httpURLConnection.getResponseCode();
                System.out.println("responseCode = " + n);
                InputStream inputStream = httpURLConnection.getErrorStream();
                if (inputStream != null) {
                    object = new String(ByteStreams.toByteArray(inputStream));
                    System.err.println((String)object);
                } else {
                    System.err.println("error stream is null lol");
                }
                object = httpURLConnection.getInputStream();
                ((InputStream)object).close();
                httpURLConnection.disconnect();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        if (crashReportBridge.bridge$getCause() instanceof OutOfMemoryError) {
            new Thread(() -> JOptionPane.showMessageDialog(null, "Your client has ran out of memory.\nYou can increase memory allocation in the launcher. \n\nPlease use the following code (also copied to your clipboard) when submitting a bug report: \n\n" + string, "Out of Memory", 2)).start();
        } else {
            new Thread(() -> JOptionPane.showMessageDialog(null, "Your client has crashed. \n\nPlease use the following code (also copied to your clipboard) when submitting a bug report: \n\n" + string, "Something went wrong", 2)).start();
        }
        try {
            Thread.sleep(7000L);
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        Ref.lIlIlIlIlIIlIIlIIllIIIIIl(new llllIIlIIlIIlIIllIIlIIllI(string));
    }

    public static ClientContext lIlIlIlIlIIlIIlIIllIIIIIl() {
        boolean bl = LunarClient.IIllIlIllIlIllIllIllIllII() != null && LunarClient.IIllIlIllIlIllIllIllIllII().lllllIllIllIllllIlIllllII() != null;
        String string = bl ? Ref.IlllIIIIIIlllIlIIlllIlIIl().lllllIllIllIllllIlIllllII().llIlllIIIllllIIlllIllIIIl().stream().filter(Feature::IlllIIIIIIlllIlIIlllIlIIl).map(configurableFeature -> configurableFeature.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl()).collect(Collectors.joining(",")) : "unknown";
        Runtime runtime = Runtime.getRuntime();
        String string2 = bl ? (Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentServerData() == null ? "None" : Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentServerData().bridge$serverIP()) : "unknown";
        return new ClientContext(Bridge.IlllIIIIIIlllIlIIlllIlIIl().IlIlIlllllIlIIlIlIlllIlIl(), AssetsWebSocket.lIlIlIlIlIIlIIlIIllIIIIIl, "master", "6f9eb864d0d24cafb109d638a849d13ad67d5979", bl ? Bridge.lIlIIIIIIlIIIllllIllIIlII().bridge$getCPU() : "unknown", "unknown", System.getProperty("os.name"), string2, LunarClient.llIIIIllIlIIlIlIIlllIllIl(), System.getProperty("java.version"), (int)((double)runtime.totalMemory() / 1048576.0), (int)((double)runtime.freeMemory() / 1048576.0), (int)((double)runtime.maxMemory() / 1048576.0), bl ? Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getDebugFPS() : -1, bl ? LunarClient.IIllIlIllIlIllIllIllIllII().lIIlIIlllIIIIlIlllIIIIlll() : ImmutableList.of(), ImmutableList.of());
    }

    public static class lIlIlIlIlIIlIIlIIllIIIIIl {
        @SerializedName(value="id")
        public final String lIlIlIlIlIIlIIlIIllIIIIIl;
        @SerializedName(value="section")
        public final String IlllIIIIIIlllIlIIlllIlIIl;
        @SerializedName(value="description")
        public final String lIllIlIIIlIIIIIIIlllIlIll;
        @SerializedName(value="context")
        public final ClientContext llIlllIIIllllIIlllIllIIIl;

        public lIlIlIlIlIIlIIlIIllIIIIIl(String string, String string2, String string3, ClientContext clientContext) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl = string;
            this.IlllIIIIIIlllIlIIlllIlIIl = string2;
            this.lIllIlIIIlIIIIIIIlllIlIll = string3;
            this.llIlllIIIllllIIlllIllIIIl = clientContext;
        }
    }

    public static class IlllIIIIIIlllIlIIlllIlIIl {
        @SerializedName(value="id")
        public final String lIlIlIlIlIIlIIlIIllIIIIIl;
        @SerializedName(value="report")
        public final CrashReportBridge IlllIIIIIIlllIlIIlllIlIIl;
        @SerializedName(value="context")
        public final ClientContext lIllIlIIIlIIIIIIIlllIlIll;

        public IlllIIIIIIlllIlIIlllIlIIl(String string, CrashReportBridge crashReportBridge, ClientContext clientContext) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl = string;
            this.IlllIIIIIIlllIlIIlllIlIIl = crashReportBridge;
            this.lIllIlIIIlIIIIIIIlllIlIll = clientContext;
        }
    }
}