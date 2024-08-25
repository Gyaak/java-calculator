public class Calculator {

    public int add(String s) {
        String reg = getRegex(s);
        s= s.substring(4);
        String[] parse = s.split(reg);
        int result = 0;
        try {
            for(String n : parse) {
                int tmp = Integer.parseInt(n);
                if(tmp<0) {
                    throw new RuntimeException("음수입니다.");
                }
                result += tmp;
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자 이외의 값입니다.");
        }
        return result;
    }

    private String getRegex(String s) {
        if(s.startsWith("//") && s.indexOf("\n")==3) {
            return "[,:" + s.charAt(2) + "]";
        }
        return "[,:]";
    }
}
