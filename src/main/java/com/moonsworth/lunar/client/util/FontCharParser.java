package com.moonsworth.lunar.client.util;

import com.moonsworth.lunar.bridge.minecraft.util.EnumChatColor;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Decencies
 * @since 10/07/2021 16:24
 */
public class FontCharParser {
    public static final String lIlIlIlIlIIlIIlIIllIIIIIl = "ÀÁÂÈÊËÍÓÔÕÚßãõğİıŒœŞşŴŵžȇ !\\\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~ÇüéâäàåçêëèïîìÄÅÉæÆôöòûùÿÖÜø£Ø×ƒáíóúñÑªº¿®¬½¼¡«»░▒▓│┤╡╢╖╕╣║╗╝╜╛┐└┴┬├─┼╞╟╚╔╩╦╠═╬╧╨╤╥╙╘╒╓╫╪┘┌█▄▌▐▀αβΓπΣσμτΦΘΩδ∞∅∈∩≡±≥≤⌠⌡÷≈°∙·√ⁿ²■";
    public static final Pattern IlllIIIIIIlllIlIIlllIlIIl = Pattern.compile("(?i)" + '§' + "[0-9A-FR]");
    public static final lIllIlIIIlIIIIIIIlllIlIll lIllIlIIIlIIIIIIIlllIlIll = new lIllIlIIIlIIIIIIIlllIlIll();

    public static String lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        Matcher matcher = IlllIIIIIIlllIlIIlllIlIIl.matcher(string);
        String string2 = EnumChatColor.IllIllIIIllIIIlIlIlIIIIll + "";
        while (matcher.find()) {
            string2 = matcher.group();
        }
        return string2;
    }

    // todo don't know origin of exception handling
    @SneakyThrows
    public static List IlllIIIIIIlllIlIIlllIlIIl(String string) {
        return lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(string);
    }

    public static class lIllIlIIIlIIIIIIIlllIlIll {
        public List<Element> lIlIlIlIlIIlIIlIIllIIIIIl(String string) throws llIlllIIIllllIIlllIllIIIl {
            ArrayList<Element> arrayList = new ArrayList<>();
            Element element = null;
            int n = 0;
            for (char c : string.toCharArray()) {
                llllIIlIIlIIlIIllIIlIIllI llllIIlIIlIIlIIllIIlIIllI2 = llllIIlIIlIIlIIllIIlIIllI.lIlIlIlIlIIlIIlIIllIIIIIl(c);
                switch (llllIIlIIlIIlIIllIIlIIllI2) {
                    case OPEN: {
                        if (element != null) {
                            arrayList.add(element);
                        }
                        element = new Element(ElementType.llIlllIIIllllIIlllIllIIIl, "", null);
                        break;
                    }
                    case CLOSE: {
                        if (element == null) break;
                        arrayList.add(element);
                        element = null;
                        break;
                    }
                    case HEX: {
                        if (element == null || element.IlllIIIIIIlllIlIIlllIlIIl() != ElementType.llIlllIIIllllIIlllIllIIIl) break;
                        element.lIlIlIlIlIIlIIlIIllIIIIIl(ElementType.IlllIIIIIIlllIlIIlllIlIIl);
                        break;
                    }
                    case ASSIGN: {
                        if (element == null || element.IlllIIIIIIlllIlIIlllIlIIl() != ElementType.llIlllIIIllllIIlllIllIIIl) break;
                        element.lIlIlIlIlIIlIIlIIllIIIIIl(ElementType.lIlIlIlIlIIlIIlIIllIIIIIl);
                        break;
                    }
                    default: {
                        if (element == null) {
                            element = new Element(ElementType.lIllIlIIIlIIIIIIIlllIlIll, "", null);
                        }
                        if (element.IlllIIIIIIlllIlIIlllIlIIl() != ElementType.lIlIlIlIlIIlIIlIIllIIIIIl) {
                            if (element.IlllIIIIIIlllIlIIlllIlIIl() == ElementType.IlllIIIIIIlllIlIIlllIlIIl) {
                                if (c >= '0' && c <= '9' || c >= 'a' && c <= 'f' || c >= 'A' && c <= 'F') {
                                    element.lIlIlIlIlIIlIIlIIllIIIIIl(element.lIllIlIIIlIIIIIIIlllIlIll() + c);
                                    break;
                                }
                                throw new llIlllIIIllllIIlllIllIIIl("expected hexadecimal number but found invalid character '" + c + "' at index " + n);
                            }
                            element.lIlIlIlIlIIlIIlIIllIIIIIl(element.lIllIlIIIlIIIIIIIlllIlIll() + c);
                            break;
                        }
                        element.IlllIIIIIIlllIlIIlllIlIIl(element.lIlIlIlIlIIlIIlIIllIIIIIl().isPresent() ? element.lIlIlIlIlIIlIIlIIllIIIIIl().get() + c : String.valueOf(c));
                    }
                }
                ++n;
            }
            arrayList.add(element);
            return arrayList;
        }
    }

    public static class Element {
        public ElementType lIlIlIlIlIIlIIlIIllIIIIIl;
        public String IlllIIIIIIlllIlIIlllIlIIl;
        public String lIllIlIIIlIIIIIIIlllIlIll;

        public Element(ElementType elementType, String string, String string2) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl = elementType;
            this.IlllIIIIIIlllIlIIlllIlIIl = string;
            this.lIllIlIIIlIIIIIIIlllIlIll = string2;
        }

        public Optional<String> lIlIlIlIlIIlIIlIIllIIIIIl() {
            return Optional.ofNullable(this.lIllIlIIIlIIIIIIIlllIlIll);
        }

        public String toString() {
            return "Element{type=" + this.lIlIlIlIlIIlIIlIIllIIIIIl + ", text='" + this.IlllIIIIIIlllIlIIlllIlIIl + '\'' + ", value='" + this.lIllIlIIIlIIIIIIIlllIlIll + '\'' + '}';
        }

        public ElementType IlllIIIIIIlllIlIIlllIlIIl() {
            return this.lIlIlIlIlIIlIIlIIllIIIIIl;
        }

        public String lIllIlIIIlIIIIIIIlllIlIll() {
            return this.IlllIIIIIIlllIlIIlllIlIIl;
        }

        public void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
            this.IlllIIIIIIlllIlIIlllIlIIl = string;
        }

        public void IlllIIIIIIlllIlIIlllIlIIl(String string) {
            this.lIllIlIIIlIIIIIIIlllIlIll = string;
        }

        public void lIlIlIlIlIIlIIlIIllIIIIIl(ElementType elementType) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl = elementType;
        }
    }

    public enum ElementType {
        lIlIlIlIlIIlIIlIIllIIIIIl,
        IlllIIIIIIlllIlIIlllIlIIl,
        lIllIlIIIlIIIIIIIlllIlIll,
        llIlllIIIllllIIlllIllIIIl

    }

    public enum llllIIlIIlIIlIIllIIlIIllI {
        OPEN,
        CLOSE,
        HEX,
        ASSIGN,
        TEXT;

        public static llllIIlIIlIIlIIllIIlIIllI lIlIlIlIlIIlIIlIIllIIIIIl(char c) {
            switch (c) {
                case '<': {
                    return OPEN;
                }
                case '>': {
                    return CLOSE;
                }
                case ':': {
                    return ASSIGN;
                }
                case '#': {
                    return HEX;
                }
            }
            return TEXT;
        }
    }

    public static class llIlllIIIllllIIlllIllIIIl extends Exception {
        public llIlllIIIllllIIlllIllIIIl(String string) {
            super(string);
        }
    }
}
