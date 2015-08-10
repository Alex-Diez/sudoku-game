package com.google.jam.unit.solvers;

import java.util.HashMap;
import java.util.Map;

class StandingOvationTestDataProvider
        implements TestDataProvider {

    @Override
    public Map<Integer, Integer> provideSmallSetOfTestData() {
        Map<Integer, Integer> results = new HashMap<>();
        results.put(1, 0);results.put(2, 1);results.put(3, 2);results.put(4, 0);
        return results;
    }

    @Override
    public Map<Integer, Integer> provideSmallSetOfPracticeData() {
        Map<Integer, Integer> result = new HashMap<>(100);
        result.put(1, 0);result.put(2, 1);result.put(3, 6);result.put(4, 0);
        result.put(5, 0);result.put(6, 0);result.put(7, 0);result.put(8, 1);
        result.put(9, 0);result.put(10, 2);result.put(11, 0);result.put(12, 0);
        result.put(13, 6);result.put(14, 2);result.put(15, 0);result.put(16, 0);
        result.put(17, 2);result.put(18, 3);result.put(19, 6);result.put(20, 0);
        result.put(21, 6);result.put(22, 1);result.put(23, 0);result.put(24, 0);
        result.put(25, 0);result.put(26, 0);result.put(27, 2);result.put(28, 0);
        result.put(29, 0);result.put(30, 6);result.put(31, 0);result.put(32, 2);
        result.put(33, 2);result.put(34, 2);result.put(35, 0);result.put(36, 0);
        result.put(37, 1);result.put(38, 0);result.put(39, 1);result.put(40, 4);
        result.put(41, 0);result.put(42, 0);result.put(43, 0);result.put(44, 0);
        result.put(45, 2);result.put(46, 0);result.put(47, 2);result.put(48, 0);
        result.put(49, 6);result.put(50, 1);result.put(51, 0);result.put(52, 0);
        result.put(53, 6);result.put(54, 1);result.put(55, 0);result.put(56, 0);
        result.put(57, 2);result.put(58, 0);result.put(59, 1);result.put(60, 3);
        result.put(61, 0);result.put(62, 0);result.put(63, 2);result.put(64, 0);
        result.put(65, 1);result.put(66, 1);result.put(67, 1);result.put(68, 0);
        result.put(69, 0);result.put(70, 0);result.put(71, 2);result.put(72, 0);
        result.put(73, 6);result.put(74, 0);result.put(75, 1);result.put(76, 0);
        result.put(77, 1);result.put(78, 1);result.put(79, 0);result.put(80, 0);
        result.put(81, 0);result.put(82, 0);result.put(83, 2);result.put(84, 1);
        result.put(85, 0);result.put(86, 6);result.put(87, 0);result.put(88, 0);
        result.put(89, 3);result.put(90, 0);result.put(91, 0);result.put(92, 0);
        result.put(93, 0);result.put(94, 0);result.put(95, 1);result.put(96, 0);
        result.put(97, 0);result.put(98, 6);result.put(99, 2);result.put(100, 6);
        return result;
    }

    @Override
    public Map<Integer, Integer> provideLargeSetOfPracticeData() {
        Map<Integer, Integer> result = new HashMap<>(100);
        result.put(1, 0);result.put(2, 0);result.put(3, 0);result.put(4, 25);
        result.put(5, 0);result.put(6, 0);result.put(7, 0);result.put(8, 60);
        result.put(9, 18);result.put(10, 4);result.put(11, 0);result.put(12, 0);
        result.put(13, 2);result.put(14, 38);result.put(15, 0);result.put(16, 21);
        result.put(17, 68);result.put(18, 0);result.put(19, 14);result.put(20, 0);
        result.put(21, 0);result.put(22, 0);result.put(23, 0);result.put(24, 34);
        result.put(25, 15);result.put(26, 38);result.put(27, 0);result.put(28, 4);
        result.put(29, 0);result.put(30, 0);result.put(31, 0);result.put(32, 10);
        result.put(33, 0);result.put(34, 83);result.put(35, 0);result.put(36, 0);
        result.put(37, 15);result.put(38, 0);result.put(39, 13);result.put(40, 27);
        result.put(41, 0);result.put(42, 0);result.put(43, 76);result.put(44, 41);
        result.put(45, 15);result.put(46, 29);result.put(47, 33);result.put(48, 0);
        result.put(49, 0);result.put(50, 0);result.put(51, 4);result.put(52, 0);
        result.put(53, 0);result.put(54, 109);result.put(55, 0);result.put(56, 46);
        result.put(57, 0);result.put(58, 0);result.put(59, 67);result.put(60, 30);
        result.put(61, 15);result.put(62, 50);result.put(63, 1000);result.put(64, 0);
        result.put(65, 0);result.put(66, 33);result.put(67, 0);result.put(68, 5);
        result.put(69, 0);result.put(70, 0);result.put(71, 58);result.put(72, 61);
        result.put(73, 87);result.put(74, 16);result.put(75, 1);result.put(76, 0);
        result.put(77, 0);result.put(78, 118);result.put(79, 0);result.put(80, 0);
        result.put(81, 0);result.put(82, 0);result.put(83, 0);result.put(84, 10);
        result.put(85, 22);result.put(86, 0);result.put(87, 24);result.put(88, 5);
        result.put(89, 30);result.put(90, 18);result.put(91, 0);result.put(92, 0);
        result.put(93, 0);result.put(94, 0);result.put(95, 2);result.put(96, 33);
        result.put(97, 6);result.put(98, 21);result.put(99, 114);result.put(100, 0);
        return result;
    }
}