package com.string.jdk8;
// package com.stringinjava8;
//
// import java.util.StringJoiner;
//
// import org.apache.commons.lang3.time.StopWatch;
//
// public class StringJoinerTest {
//
// public static void main(String[] args) {
// /** StringJoiner性能测试开始 **/
// // 111111111111111111111
// StopWatch sw = new StopWatch();
// sw.start();
// // 拼接
// StringJoiner sj = new StringJoiner(",");
// for (int i = 0; i < 100000; i++) {
// sj.add(String.valueOf(i));
// }
// // System.out.println(sj.toString());// aaa,bbb,ccc
// System.out.println(sw.getTime());
//
// // 22222222222222222222222
// StopWatch sw2 = new StopWatch();
// sw2.start();
// StringBuilder sb = new StringBuilder();
// for (int i = 0; i < 100000; i++) {
// sb.append(String.valueOf(i)).append(",");
// }
// String ss = sb.toString().substring(0, sb.toString().length() - 1);
// // System.out.println(ss);// aaa,bbb,ccc
// System.out.println(sw2.getTime());
// /** StringJoiner性能测试结束 **/
//
// StringJoiner sj2 = new StringJoiner("-", "prefix", "suffix");
// sj2.add("2016");
// sj2.add("02");
// sj2.add("26");
// System.out.println(sj2.toString()); // prefix2016-02-26suffix
//
// }
// }
