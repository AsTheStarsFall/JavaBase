//package com.tianhy.javabase.codewar;
//
//import org.apache.log4j.Logger;
//
//import java.math.BigDecimal;
//import java.math.BigInteger;
//import java.sql.Timestamp;
//import java.text.SimpleDateFormat;
//import java.time.*;
//import java.time.format.DateTimeFormatter;
//import java.util.*;
//import java.util.function.BinaryOperator;
//import java.util.stream.*;
//
//public class CodeWarPractices {
//
//    private static Logger log = Logger.getLogger(CodeWarPractices.class);
//
//    @Test
//    private void LocalDate() {
//        LocalDate date = LocalDate.now();
//        System.out.println("1:" + date.toString());
//        date.getYear();// ymd
//        date.toString();
//        log.debug("2:" + date);
//    }
//
//    @Test
//    public void LocalTime() {
//        LocalTime time = LocalTime.now();
//        time.getHour();// hms
//        time.toString();
//        log.debug(time);
//    }
//
//    @Test
//    public void LocalDateTime() {
//        Timestamp t = new Timestamp(System.currentTimeMillis());
//        //System.out.println(t.toLocalDateTime());
//        LocalDateTime dateTime = LocalDateTime.now();
//        dateTime.toString();
//        //log.debug(dateTime);// ymd hms
//    }
//
//    @Test
//    public void DateTimeFormatter() { // string-->time
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDateTime dt = LocalDateTime.parse("2017-11-09 13:44:01", dtf);
//        log.debug(dt.toString());
//
//    }
//
//    @Test
//    public void convert() throws Exception { // time convert
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//        // Calendar-->String
//        Calendar calendar = Calendar.getInstance();
//        String str = sdf.format(calendar.getTime());
//
//        // Calendar-->Timestamp
//        new Timestamp(Calendar.getInstance().getTimeInMillis());
//
//        // Calendar-->Date
//        Date date1 = calendar.getTime();
//
//        // String-->Calendar
//        String str3 = "2017-11-09 16:35:01";
//        Date date = sdf.parse(str3);// String-->Date
//        calendar.setTime(date);
//
//        // Date-->String
//        String str1 = sdf.format(new Date());
//        // Date-->Callendar
//        Date date3 = new Date();
//        calendar.setTime(date3);
//        // Date-->Timestamp
//        new Timestamp(date3.getTime());
//
//        // String-->Timestamp
//        Timestamp ts = Timestamp.valueOf("2017-11-09 16:35:01");
//        // Timestamp-->String
//        String str2 = sdf.format(ts);
//
//    }
//
//    @Test
//    public void test() {
//        int a = Integer.valueOf("123");
//        Integer.valueOf("10");
//        Integer.parseInt("10");
//        System.err.println(a);
//    }
//
//    // 输入数字，转为倒序,return array
//    public static int[] digitize(long n) {
//        // string as int convert to else type
//        return new StringBuilder().append(n).reverse().chars().map(Character::getNumericValue).toArray();
//
//    }
//
//    @Test
//    public void digitize() {
//
//
//        int[] a = digitize(123456);
//        for (int i : a) {
//            System.err.print(i);
//        }
//    }
//
//    // 加减乘除
//    public static Integer basciMath(String op, int v1, int v2) {
//        switch (op) {
//            case "+":
//                return v1 + v2;
//            case "-":
//                return v1 - v2;
//            case "*":
//                return v1 * v2;
//            case "/": {
//                if (v2 == 0) {
//                    throw new IllegalArgumentException("Division by zero");
//                }
//                return v1 / v2;
//            }
//            default:
//                throw new IllegalArgumentException("Unknowm operation:" + op);
//        }
//    }
//
//    // + - * /
//    public static int arithmetic(int a, int b, String op) {
//        switch (op) {
//            case "add":
//                return a + b;
//            case "subtract":
//                return a - b;
//            case "multiply":
//                return a * b;
//            case "divide":
//                if (b == 0) {
//                    throw new IllegalArgumentException("Division by zero");
//                }
//                return a / b;
//            default:
//                throw new IllegalArgumentException("Unknowm operation:" + op);
//        }
//    }
//
//    @Test
//    public void arithmetic() {
//        System.err.println(arithmetic(5, 2, "divide"));
//    }
//
//    @Test
//    public void math() {
//        Integer a = basciMath("/", 8, 4);
//        log.debug(a);
//    }
//
//    // desc number
//    public static int sortDesc(final int num) {
//
//        return Integer.parseInt(String.valueOf(num).chars().mapToObj(i -> String.valueOf(Character.getNumericValue(i)))
//                .sorted(Comparator.reverseOrder()).collect(Collectors.joining()));
//    }
//
//    @Test
//    public void sortdesc() {
//        System.err.println(sortDesc(594237));
//    }
//
//    // h--hours m--minutes s--milliseconds
//    public static int seriesClock(int h, int m, int s) {
//        return ((m + h * 60) * 60 + s) * 1000;
//    }
//
//    @Test
//    public void hms() {
//        System.err.println(seriesClock(1, 1, 1));
//
//    }
//
//    // reverse char
//    public static String reverseString(String str) {
//        return new StringBuilder(str).reverse().toString();
//    }
//
//    @Test
//    public void reverseString() {
//        System.err.println(reverseString("avaj"));
//    }
//
//    // find string in the Object[]
//    public static String foundNeedle(Object[] haystack) {
//        return String.format("found the needle at position %d", Arrays.asList(haystack).indexOf("needle"));
//
//    }
//
//    @Test
//    public void foundNeedle() {
//        Object[] haystack1 = {true, false, 2, "jack", null, "needle"};
//        System.err.println(foundNeedle(haystack1));
//
//    }
//
//    // get middle word
//    public static String getMiddle(String str) {
//        int length = str.length();
//        // from begin to end
//        return (length % 2 == 0) ? str.substring(length / 2 - 1, length / 2 + 1)
//                : String.valueOf(str.charAt(length / 2));
//    }
//
//    @Test
//    public void getMiddle() {
//        System.err.println(getMiddle("hello"));
//
//    }
//
//    // find different number
//    public static int stray(int[] numbers) {
//        // return Arrays.stream(numbers).reduce(0, (a, b) -> a ^ b);
//
//        if (numbers[0] != numbers[1] && numbers[0] != numbers[2]) {
//            return numbers[0];
//        }
//        for (int i : numbers)
//            if (numbers[0] != i) {
//                return i;
//            }
//        return 0;
//    }
//
//    @Test
//    public void stray() {
//        int[] a = {3, 3, 3, 5, 3, 3, 3};
//        System.err.println(stray(a));
//
//    }
//
//    // 4--> 1010
//    // 3--> 101
//    // 2--> 10
//    // 1--> 1
//    public static String stringfString(int size) {
//        StringBuilder sBuilder = new StringBuilder();
//        for (int i = 0; i < size; i++) {
//            if (i % 2 == 0)
//                sBuilder.append(1);
//            else
//                sBuilder.append(0);
//        }
//        return sBuilder.toString();
//    }
//
//    @Test
//    public void test1() {
//        System.err.println(stringfString(5));
//
//    }
//
//    // first letter uppercase
//    public static String toCase(String str) {
//        if (str == null && str.length() == 0)
//            return null;
//        return Arrays.stream(str.split(" ")).map(i -> i.substring(0, 1).toUpperCase() + i.substring(1, i.length()))
//                .collect(Collectors.joining(" "));
//
//        // if (null == str && str.equals(""))
//        // return null;
//        // char[] array = str.toCharArray();
//        // for (int i = 0; i < array.length; i++) {
//        // if (i == 0 || array[i - 1] == ' ')
//        // array[i] = Character.toUpperCase(array[i]);
//        // }
//        // return new String(array);
//    }
//
//    @Test
//    public void toCase() {
//        System.err.println(toCase("java is nice"));
//    }
//
//    // min digit in array
//    public static int minArray(int[] args) {
//        IntStream.of(args).max().getAsInt();
//        return IntStream.of(args).min().getAsInt();
//
//        // Arrays.sort(args);
//        // return args[0];
//    }
//
//    // max digit in array
//    public static int maxArray(int[] args) {
//
//        // return IntStream.of(args).max().getAsInt();
//
//        int max = args[0];
//        for (int i = 1; i < args.length; i++) {
//            if (args[i] > max) {
//                max = args[i];
//            }
//        }
//        return max;
//    }
//
//    @Test
//    public void minArray() {
//        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        System.err.println(a);
//    }
//
//    // HashMap containsKey
//    public static String greet(String str) {
//        HashMap<String, String> hm = new HashMap<>();
//        hm.put("1", "java");
//        hm.put("2", "nice");
//        hm.put("3", "code");
//        hm.put("4", "bug");
//
//        if (hm.containsKey(str)) {
//            return hm.get(str);
//        } else {
//            return hm.get("3");
//        }
//    }
//
//    @Test
//    public void greet() {
//        System.err.println(greet("1"));
//
//    }
//
//    // repeat(repeat,string) string
//    public static String repeatString(int repeat, String str) {
//        // StringBuilder sb = new StringBuilder();
//        // for (int i = 0; i < repeat; i++) {
//        // sb.append(str);
//        // sb.append(" ");
//        // }
//        // return sb.toString();
//
//        // return IntStream.range(0, repeat).mapToObj(i ->
//        // str).collect(Collectors.joining()).toString();
//        return repeat < 0 ? "" : String.join(",", Collections.nCopies(repeat, str));
//    }
//
//    @Test
//    public void repeat() {
//        System.err.println(repeatString(5, "java"));
//
//    }
//
//    // count people in the bus
//    private static int countPassengers(ArrayList<int[]> stops) {
//        // return stops.stream().mapToInt(i -> i[0] - i[1]).sum();
//
//        int temp = 0;
//        for (int[] is : stops) {
//            temp += is[0];
//            temp -= is[1];
//        }
//        return temp;
//    }
//
//    @Test
//    public void count() {
//        ArrayList<int[]> list = new ArrayList<int[]>();
//        list.add(new int[]{10, 5});
//        list.add(new int[]{6, 3});
//        list.add(new int[]{1, 7});
//        System.err.println(countPassengers(list));
//
//    }
//
//    // find string in the String array
//    public static Boolean find(String needle, String[] haystack) {
//        // for (String h : haystack) {
//        // if(h.equals(needle)) return true;
//        // return false;
//        // }
//        // return false;
//
//        return Arrays.asList(haystack).contains(needle);
//    }
//
//    @Test
//    public void find() {
//        System.err.println(find("java", new String[]{"java", "is", "nice"}));
//
//    }
//
//    // get country's currency symbol
//    public static String getSymbol(String country) {
//        for (final Locale locale : Locale.getAvailableLocales()) {
//            if (locale.getDisplayCountry().equalsIgnoreCase(country)) {
//                return Currency.getInstance(locale).getCurrencyCode();
//            }
//        }
//        throw new IllegalArgumentException("Country: " + country);
//    }
//
//    // no five
//    public static long noFive(int start, int end) {
//        // int sum=0;
//        // for(int i=start;i<=end;i++){
//        // if(!(""+i).contains("5")) sum++;
//        // }
//        // return sum;
//
//        return IntStream.rangeClosed(start, end).filter(x -> !String.valueOf(x).matches(".*5.*")).count();
//    }
//
//    @Test
//    public void noFive() {
//        System.err.println(noFive(1, 16));
//    }
//
//    // binary to number
//    public static int convertBinaryToNumber(List<Integer> binary) {
//        return binary.stream().reduce((x, y) -> x * 2 + y).get();
//    }
//
//    @Test
//    public void binaryToNumber() {
//        // 1,0,1,1 -> 11
//        System.err.println(convertBinaryToNumber(new ArrayList<>(Arrays.asList(1, 0, 1, 1))));
//    }
//
//    // fighters infomation
//    public class Fighter {
//        public String name;
//        public int health, damagePerAttack;
//
//        public Fighter(String name, int health, int damagePerAttack) {
//            this.name = name;
//            this.health = health;
//            this.damagePerAttack = damagePerAttack;
//        }
//    }
//
//    // who win??
//    public static String winnner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
//        Fighter a = fighter1, b = fighter2;
//        if (firstAttacker.contains(fighter2.name)) {
//            a = fighter2;
//        }
//        b = fighter1;
//
//        while (true) {
//            if ((a.health -= b.damagePerAttack) <= 0) {
//                return b.name + " win!";
//            }
//            if ((b.health -= a.damagePerAttack) <= 0) {
//                return a.name + " win!";
//            }
//        }
//    }
//
//    @Test
//    public void winner() {
//        Fighter a = new Fighter("Cat", 100, 40);
//        Fighter b = new Fighter("Dog", 80, 55);
//        System.err.println(winnner(a, b, b.name));
//    }
//
//    // JAVA IS NICE <-> java is nice
//    public static String alterString(String string) {
//        String string2 = "";
//        for (char c : string.toCharArray()) {
//            if (Character.isUpperCase(c)) {
//                string2 += Character.toLowerCase(c);
//            } else {
//                string2 += Character.toUpperCase(c);
//            }
//        }
//        return string2;
//    }
//
//    @Test
//    public void alterString() {
//        System.err.println(alterString("jAVA iS nICE"));
//    }
//
//    // count true
//    public static int counting(Boolean[] arrayOfSheeps) {
//        // int count=0;
//        // for(Boolean b:arrayOfSheeps){
//        // if(b) count++;
//        // }
//        // return count;
//
//        return (int) Arrays.stream(arrayOfSheeps).filter(Boolean::booleanValue).count();
//    }
//
//    @Test
//    public void counting() {
//        Boolean[] booleans = {true, false, true, false, true, false, true, false, true, false, true, true, true, true,
//                false, false};
//        System.err.println(counting(booleans));
//    }
//
//    // n
//    // 1-2-3-...-n
//    public static int[] numberCount(int a) {
//
//        return IntStream.rangeClosed(1, a).toArray();
//
//        // int[] num=new int[a];
//        // for(int i=0;i<num.length;i++){
//        // num[i]+=i+1;
//        // }
//        // return num;
//
//    }
//
//    @Test
//    public void numberCount() {
//        int[] a = numberCount(10);
//        for (int i : a) {
//            System.err.print(i + "-");
//        }
//    }
//
//    // 石头剪刀布
//    public static String rps(String p1, String p2) {
//        if (p1 == p2)
//            return "Draw!";
//        int a = (p1 + p2).equals("scissorspaper") || (p1 + p2).equals("rockscissors") || (p1 + p2).equals("paperrock")
//                ? 1 : 2;
//        return "Player" + a + " won!";
//
//    }
//
//    @Test
//    public void rps() {
//        String rock = "rock", scissors = "scissors", paper = "paper";
//        System.err.println(rps(rock, paper));
//    }
//
//    // n
//    // 1+2+3+...+n=?
//    public static String showSum(int value) {
//        String string = "";
//        if (value < 0)
//            return "" + value + "<0";
//        if (value == 0)
//            return "" + value + "=0";
//        for (int i = 0; i <= value; i++) {
//            string += "" + i + "+";
//            // 遍历完的 string -> 1+2+3+4+
//        }
//        // string.length()-1 去掉 '+' 号
//        return string.substring(0, string.length() - 1) + "=" + (value * (value + 1) / 2);
//    }
//
//    @Test
//    public void shouNum() {
//        System.err.println(showSum(10));
//    }
//
//    // n
//    // 1+2+3+...+n=?
//    public static int summation(int n) {
//        return (n * (n + 1)) / 2;
//    }
//
//    @Test
//    public void summation() {
//        System.err.println(summation(10));
//    }
//
//    // return new string
//    public static String smash(String... strs) {
//        // StringBuilder stringBuilder=new StringBuilder();
//        // for (String string : strs) {
//        // stringBuilder.append(string+" ");
//        // }
//        // return stringBuilder.toString().trim();
//
//        // return String.join(" ", strs);
//
//        return String.join(" ", Arrays.asList(strs));
//
//    }
//
//    @Test
//    public void smash() {
//        String[] strs = {"java", "is", "nice"};
//        System.err.println(smash(strs));
//    }
//
//    // + - * /
//    static Map<String, BinaryOperator<Integer>> operators = new HashMap<>();
//
//    static {
//        operators.put("add", (a, b) -> a + b);
//        operators.put("subtract", (a, b) -> a - b);
//        operators.put("multiply", (a, b) -> a * b);
//        operators.put("divide", (a, b) -> a / b);
//    }
//
//    private static Integer asmd(int a, int b, BinaryOperator<Integer> operator) {
//        return Optional.ofNullable(operator).orElse((x, y) -> 0).apply(a, b);
//    }
//
//    public static int asmd(int a, int b, String op) {
//        return asmd(a, b, operators.get(op));
//    }
//
//    public static String howMuchILoveU(int petals) {
//        String[] strings = {"I love you", "a little", "a lot", "passionately", "madly", "not at all"};
//        return strings[(petals - 1) % 6];
//    }
//
//    @Test
//    public void howMuchILoveYou() {
//        System.err.println(howMuchILoveU(2));
//    }
//
//    public static String whoIsNext(String[] names, int a) {
//        String[] name = {"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
//        return name[(a - 1) % 5];
//    }
//
//    @Test
//    public void whoIsNext() {
//        String[] name = {"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
//        System.err.println(whoIsNext(name, 2));
//    }
//
//    public static String expandedForm(int num) {
//        int a = 123;
//        String string = String.valueOf(a);
//        char[] array = string.toCharArray();
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] != 0) {
//            }
//        }
//        return string;
//
//    }
//
//    @Test
//    public void expandedForm() {
//
//    }
//
//    public static int enough(int cap, int on, int wait) {
//        return Math.max(0, on + wait - cap);
//    }
//
//    @Test
//    public void enough() {
//        System.err.println(enough(100, 50, 60));
//    }
//
//    private static int[] parseAndSortInput(String string) {
//        String[] strings = string.split(" ");
//        int[] values = Arrays.stream(strings).mapToInt(s -> Integer.valueOf(s)).toArray();
//        Arrays.sort(values);
//        return values;
//    }
//
//    // find missing number
//    public static int findMissingNumber(String string) {
//        if (string == null && string.isEmpty())
//            return 0;
//
//        int values[];
//        try {
//            values = parseAndSortInput(string);
//        } catch (NumberFormatException e) {
//            return 1;
//        }
//
//        OptionalInt missing = IntStream.range(0, values.length).filter(i -> (i + 1) != values[i]).findFirst();
//        return missing.isPresent() ? missing.getAsInt() + 1 : 0;
//    }
//
//    @Test
//    public void finMissingNumber() {
//        System.err.println(findMissingNumber("1 2 3 5"));
//    }
//
//    // String.format( , )
//    public static String sayHello(String[] names, String city, String state) {
//
//        return String.format("Hello, %s! Welcome to %s, %s!", String.join(" ", names), city, state);
//    }
//
//    @Test
//    public void sayHello() {
//        String[] names = {"John", "Smith"};
//        String city = "Beijing", state = "China";
//        System.err.println(sayHello(names, city, state));
//    }
//
//    // true -> yes false -> no
//    public static String booleanWord(boolean b) {
//        return b ? "Yes" : "No";
//
//    }
//
//    private static char getChar(char c) {
//        switch (c) {
//            case 'A':
//                return 'T';
//            case 'T':
//                return 'A';
//            case 'C':
//                return 'G';
//            case 'G':
//                return 'C';
//            default:
//                break;
//        }
//        return c;
//    }
//
//    // 互补
//    public static String makeComplement(String dna) {
//        char[] chars = dna.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            chars[i] = getChar(chars[i]);
//        }
//        return new String(chars);
//    }
//
//    // string distinct
//    public static String shorter(String string1, String string2) {
//
//        StringBuilder stringBuilder = new StringBuilder();
//        // char[] chars=string1.toCharArray();
//        // for (char c : chars) {
//        // stringBuilder.append(c);
//        // }
//        (string1 + string2).chars().distinct().sorted().forEach(c -> stringBuilder.append((char) c));
//        return stringBuilder.toString();
//
//    }
//
//    public static int factorial(int i) {
//        return IntStream.rangeClosed(1, i).reduce(1, (a, b) -> a * b);
//    }
//
//    // string -> int return string
//    public static String HighestAndLowest(String numbers) {
//        int min = Arrays.stream(numbers.split(" ")).mapToInt(i -> Integer.parseInt(i)).min().getAsInt();
//        int max = Arrays.stream(numbers.split(" ")).mapToInt(i -> Integer.parseInt(i)).max().getAsInt();
//        return String.format("%d %d", max, min);
//
//    }
//
//    @Test
//    public void minAndMax() {
//        String string = "1 -18 5 99";
//        System.err.println(HighestAndLowest(string));
//    }
//
//    public static String removeExclamation(String string) {
//        return string.replaceAll("!", "");
//
//    }
//
//    public static int getCount(String string) {
//        char[] chars = string.toCharArray();
//        int a = 0;
//        for (int i = 0; i < chars.length; i++) {
//            if (chars[i] == 'a' | chars[i] == 'o' | chars[i] == 'e' | chars[i] == 'i' | chars[i] == 'u')
//                a++;
//        }
//        return a;
//
//    }
//
//    @Test
//    public void getCount() {
//        System.err.println(getCount("aoepppp"));
//    }
//
//    public static String maxAndMin(String string) {
//        char[] chars = string.toCharArray();
//        int a = 0, b = 0;
//        for (int i = 0; i < chars.length; i++) {
//            if (chars[i] == 'A')
//                a++;
//            if (chars[i] == 'B')
//                b++;
//
//        }
//        return a + "" + b;
//    }
//
//    @Test
//    public void yy() {
//        String string = "AAABBBAAABB";
//        System.err.println(maxAndMin(string));
//    }
//
//    public static boolean isTriangle(int a, int b, int c) {
//        if (a + b > c && a - b < c)
//            return true;
//        return false;
//
//    }
//
//    @Test
//    public void isTriangle() {
//        System.err.println(isTriangle(1, 2, 2));
//    }
//    // find odd appears times in the array and no repeat
//    /*
//     * public static int findOdd(int[] A) { int times=0; int temp=A[0]; for(int
//     * i=0;i<A.length;i++){ if(A[i]%2!=0){ temp=A[i];
//     *
//     * } } return times; }
//     *
//     * @Test public void finOdd(){ int[]
//     * a={20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5};
//     * System.err.println(findOdd(a)); }
//     */
//
//    /*
//     * public static String createPhoneNumber(int[] numbers) { String
//     * string2=""; String string=String.valueOf(numbers); char[]
//     * chars=string.toCharArray(); for(int i=0;i<chars.length;i++){
//     *
//     * } return string2; }
//     *
//     * @Test public void phoneNumber(){ int[] a={1,2,3,4,5,6,7,8,9,0};
//     * System.err.println(createPhoneNumber(a)); }
//     */
//
//    public static boolean xor(boolean a, boolean b) {
//        if (a == b) {
//            return false;
//        } else if (a != b) {
//            return true;
//        }
//        return b;
//    }
//
//    @Test
//    public void xor() {
//        System.err.println(xor(true, true));
//    }
//
//    public static int findShort(String string) {
//        // return Arrays.stream(string.split("
//        // ")).mapToInt(String::length).min().getAsInt();
//        return Stream.of(string.split(" ")).mapToInt(String::length).min().getAsInt();
//    }
//
//    public static String chromosomeCheck(String sperm) {
//        return sperm.equalsIgnoreCase("XY") ? "Congratulations! You're going to have a son."
//                : "Congratulations! You're going to have a daughter.";
//    }
//
//    /*
//     * public static String maskify(String str) { if(str=="") return ""; char[]
//     * chars=str.toCharArray(); Integer length=chars.length; if(length>=4){
//     * String prefix=String.join("", Collections.nCopies(length-4, "#")); String
//     * suffix=new StringBuilder().append(str.trim()).reverse().substring(0, 4);
//     * String postfix=new StringBuilder().append(suffix).reverse().toString();
//     * return prefix+postfix; }else{ return str; }
//     *
//     * }
//     */
//
//    public static String maskify(String str) {
//
//        /*
//         * if(str=="") return ""; char[] chars=str.trim().toCharArray(); try {
//         * if(chars.length>=4){
//         *
//         * StringBuilder sb = new StringBuilder(); for (int i = 0; i <
//         * chars.length-4; i++) { sb.append("#"); } String sign= sb.toString();
//         * String suffix=new
//         * StringBuilder().append(str.trim()).reverse().substring(0, 4); String
//         * postfix=new StringBuilder().append(suffix).reverse().toString();
//         * return String.join("", sign+postfix); }else{ return str; }
//         *
//         * } catch (UnsupportedOperationException e) { throw new
//         * UnsupportedOperationException("Unimplemented"); }
//         */
//        if (str.length() <= 4)
//            return str;
//        String prefix = "";
//        for (int i = 0; i < str.length() - 4; i++) {
//            prefix += "#";
//        }
//        return prefix + str.substring(str.length() - 4);
//
//    }
//
//    @Test
//    public void maskify() {
//        String string = "1234567890";
//        System.err.println(maskify(string));
//    }
//
//    public static double[] averages(int[] numbers) {
//        // final double[] ds=new
//        // double[(numbers==null||numbers.length<2)?0:numbers.length-1];
//        // for(int i=0;i<ds.length;i++) ds[i]=(numbers[i]+numbers[i+1]/2.0);
//        // return ds;
//
//        return numbers == null || numbers.length < 2 ? new double[0]
//                : IntStream.range(0, numbers.length - 1).mapToDouble(i -> (numbers[i] + numbers[i + 1]) / 2d).toArray();
//
//    }
//
//    @Test
//    public void averages() {
//        int[] is = {2, 3, 5, 1, -10};
//        double[] ds = averages(is);
//        for (double d : ds) {
//            System.err.println(d);
//        }
//
//    }
//
//    public int rentalCarCost(int d) {
//        return (d >= 3 && d <= 7) ? d * 40 - 20 : (d > 7) ? d * 40 - 50 : d * 40;
//    }
//
//    @Test
//    public void rentalCarCost() {
//        System.err.println(rentalCarCost(10));
//    }
//
//    public String solution(int n) {
//        String[] strings = {"I", "V", "X", "L", "C", "D", "M"};
//        strings[0] = String.valueOf(1);
//        strings[1] = String.valueOf(5);
//        strings[2] = String.valueOf(10);
//        strings[3] = String.valueOf(50);
//        strings[4] = String.valueOf(100);
//        strings[5] = String.valueOf(500);
//        strings[6] = String.valueOf(1000);
//        return "";
//    }
//
//    public static int saleHotdogs(final int n) {
//        return n < 5 ? n * 100 : (n >= 5 && n < 10) ? n * 95 : n * 90;
//    }
//
//    public static int nbYear(int p0, double percent, int aug, int p) {
//        Integer i = 0;
//        while (p0 < p) {
//            p0 += p0 * percent / 100 + aug;
//            i++;
//        }
//        return p0;
//    }
//
//    public static boolean scramble(String str1, String str2) {
//        char[] cs = str1.toCharArray();
//        char[] cs2 = str2.toCharArray();
//        for (int i = 0; i < cs2.length; i++) {
//            for (int j = 0; j < cs.length; j++) {
//                if (cs2[i] != cs[j]) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    @Test
//    public void scramble() {
//        System.err.println(scramble("javaaaarx", "javax"));
//    }
//
//    public static int calculateYears(double principal, double interest, double tax, double desired) {
//        int i = 0;
//        while (principal < desired) {
//            principal += principal * interest + principal * tax;
//            System.err.println(principal);
//            i++;
//            System.err.println(i);
//        }
//        return principal == desired ? 0 : i;
//    }
//
//    @Test
//    public void calculateYears() {
//        System.err.println(calculateYears(1000, 0.01625, 0.18, 1200));
//    }
//
//    public static BigInteger numberOfDots(BigInteger n) {
//        return BigInteger.valueOf(IntStream.rangeClosed(0, n.intValue()).reduce(0, (a, b) -> a + b));
//    }
//
//    @Test
//    public void numberOfDots() {
//        System.err.println(numberOfDots(BigInteger.valueOf(4L)));
//
//    }
//
//    // 平均值
//    public static double find_average(int[] array) {
//        // int temp=0;
//        // for(int i=0;i<array.length;i++){
//        // temp+=array[i];
//        // System.err.println(temp);
//        // }
//        // return (double)temp/array.length;
//        return Arrays.stream(array).average().getAsDouble();
//    }
//
//    //
//    @Test
//    public void find_average() {
//        int[] a = {1, 2, 3, 4};
//        System.err.println(find_average(a));
//    }
//
//    // count smile
//    public static int countSmileys(List<String> arr) {
//        // Just Smile :)
//        return (int) arr.stream().filter(w -> w.matches("[:;][-~]?[)D]")).count();
//    }
//
//    @Test
//    public void countSmileys() {
//        List<String> a = new ArrayList<String>();
//        a.add(":)");
//        a.add(":D");
//        a.add(":-}");
//        a.add(":-()");
//        System.err.println(countSmileys(a));
//    }
//
//    // 0~n-1之间数的平方，与d匹配，计算d出现的次数
//    public static int nbDig(int n, int d) {
//        // your code
//
//        int[] ns = new int[n];
//        int k = 0;
//        int count = 0;
//        for (int i = 1; i < ns.length; i++) {
//            // 0~n-1
//            ns[i] = i;
//            k = (int) Math.pow(ns[i], 2);
//            // System.err.println("k--"+k);
//            String kString = String.valueOf(k);
//            // System.err.println("kString--"+kString);
//            String dString = String.valueOf(d);
//            // System.err.println("dString--"+dString);
//            char[] dcs = dString.toCharArray();
//            char[] kcs = kString.toCharArray();
//            for (int j = 0; j < dcs.length; j++) {
//                System.err.println("dcs--" + dcs[j]);
//                for (int l = 0; l < kcs.length; l++) {
//                    System.err.println("----kcs--" + kcs[l]);
//                    if (dcs[j] == kcs[l]) {
//                        count++;
//                    }
//                    continue;
//                }
//                System.err.println("count--" + count);
//            }
//        }
//        return count;
//    }
//
//    @Test
//    public void nbDig() {
//        System.err.println(nbDig(11, 1));
//    }
//
//    public static String even_or_odd(int number) {
//        String even = "Even", odd = "Odd";
//        return number % 2 == 0 ? even : odd;
//    }
//
//    @Test
//    public void even_odd() {
//        System.err.println(even_or_odd(8));
//    }
//
//    // odd or even
//    public static String oddOrEven(int[] array) {
//        int sum = 0;
//        for (int i = 0; i < array.length; i++) {
//            sum += array[i];
//        }
//        return sum % 2 == 0 ? "even" : "odd";
//    }
//
//    @Test
//    public void oddOrEven() {
//        System.err.println(oddOrEven(new int[]{2, 5, 34, 6}));
//    }
//
//    public static int[] countPositivesSumNegatives(int[] input) {
//        // int count=0;
//        // int sum=0;
//        // for(int i=0;i<input.length;i++){
//        // if(input[i]>0) count++;
//        // sum+=input[i];
//        // }
//        // return new int[]{count,sum};
//
//        return new int[]{(int) IntStream.of(input).filter(i -> i > 0).count(),
//                IntStream.of(input).filter(i -> i < 0).sum()};
//    }
//
//    @Test
//    public void countPositivesSumNegatives() {
//        int[] expectedResult = new int[]{10, -65};
//        System.err.println(countPositivesSumNegatives(expectedResult));
//    }
//
//    public static int findIt(int[] A) {
//        int[] temp = new int[A.length];
//        for (int i = 0; i < A.length; i++) {
//            if (A[i] % 2 != 0)
//                temp[i] = A[i];
//        }
//        int count = 0;
//        for (int i = 0; i < temp.length; i++) {
//            for (int j = 0; j < temp.length; j++) {
//                if (temp[i] == temp[j])
//                    count++;
//            }
//        }
//        return 0;
//    }
//
//    public int cockroachSpeed(double x) {
//        // Good Luck!
//        return (int) (x * 1000 / 36);
//    }
//
//    static int find(int[] integers) {
//
//        return 0;
//
//    }
//
//    public int min(int[] list) {
//
//        // return IntStream.range(0, list.length).min().getAsInt();
//        int min = list[0];
//        for (int i = 0; i < list.length; i++) {
//            if (list[i] < min) {
//                min = list[i];
//            }
//        }
//        return min;
//    }
//
//    // max digit in array
//    public int max(int[] list) {
//        // return IntStream.range(0, list.length).max().getAsInt();
//        int max = list[0];
//        for (int i = 0; i < list.length; i++) {
//            if (list[i] > max) {
//                max = list[i];
//            }
//        }
//        return max;
//    }
//
//    // 根号Sq（整数）+1的平方
//    public static long findNextSquare(long sq) {
//        return (long) (Math.sqrt(sq) % 1 == 0 ? Math.pow(Math.sqrt(sq) + 1, 2) : -1);
//    }
//
//    // 999
//    // 9*9*9=729 7*2*9=126 1*2*6=12 1*2=2
//    // four times
//    public static int persistence(long n) {
//        // your code
//        if (n < 10)
//            return 0;
//        final long p = Arrays.stream(String.valueOf(n).split("")).mapToLong(Long::valueOf).reduce(1, (x, y) -> (x * y));
//        return persistence(p) + 1;
//    }
//
//    @Test
//    public void persistence() {
//        System.err.println(persistence(999));
//    }
//
//    //string.split返回数组
//    // WUBXXWUBXXWUBXX
//    //排除WUB取剩下的
//    public static String SongDecoder(String song) {
//
//        return Arrays.stream(song.split("WUB"))
//                .filter(i -> !"".equals(i))
//                .collect(Collectors.joining(" "));
//    }
//
//
//    public static int digital_root(int n) {
//        // ...
//        if (String.valueOf(n).length() > 1) {
//            int sum = 0;
//            String numberAsString = String.valueOf(n);
//            for (int i = 0; i < numberAsString.length(); i++) {
//                int number = Character.getNumericValue(numberAsString.charAt(i));
//                sum += number;
//            }
//            return digital_root(sum);
//        } else {
//            return n;
//        }
//    }
//
//    @Test
//    public void digital_root() {
//        System.err.println(digital_root(666));
//    }
//
//    // n--->k
//    public static int[] LotteryDrawing(int k, int n) {
//        int[] numbers = new int[n];
//        for (int i = 0; i < numbers.length; i++) {
//            numbers[i] = i + 1;
//        }
//        int[] result = new int[k];
//        for (int i = 0; i < result.length; i++) {
//            //0~n-1之间的随机数
//            int r = (int) (Math.random() * n);
//            result[i] = numbers[r];
//            //move the last element into the random location
//            numbers[r] = numbers[n - 1];
//            n--;
//        }
//        Arrays.sort(result);
//        return result;
//    }
//
//    @Test
//    public void LotteryDrawing() {
//        System.err.println(Arrays.toString(LotteryDrawing(5, 10)));
//    }
//
//    //用1~49对象填充数组，打乱顺序，并从打乱的列表中选择前6个值。最后再将选择的数值进行排序和打印
//    @Test
//    public void shuffleTest() {
//        List<Integer> numbers = new ArrayList<>();
//        for (int i = 1; i <= 49; i++) {
//            numbers.add(i);
//        }
//        Collections.shuffle(numbers);
//        List<Integer> list = numbers.subList(0, 6);
//        Collections.sort(list);
//        System.err.println(list);
//    }
//
//    public static String formatValue(String data) {
//        String a;
//        if (data == null) {
//            data = "0";
//        }
//        if (data.equalsIgnoreCase("0")) {
//            data = "0.00";
//        }
//        BigDecimal d = new BigDecimal(data);
//        d = d.setScale(2, BigDecimal.ROUND_HALF_UP);
//        data = d.toString();
//        System.out.println("data:" + data);
//        a = data.replaceAll(",", ".");
//        if (a.equalsIgnoreCase(".00")) {
//            a = "0.00";
//        }
//        if (a.charAt(0) == '.') {
//            a = "0" + a;
//        }
//        data = String.valueOf(a);
//        return data;
//    }
//
//    @Test
//    public void format() {
//        String data = "0.006";
//        System.out.println(formatValue(data));
//    }
//
//
//}
