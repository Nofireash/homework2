package utils;

import entity.Fraction;

public class FractionUtil {

    /**
     * 加法
     */
    public static Fraction add(Fraction f1, Fraction f2) {
        return new Fraction(f2.getDenominator() * f1.getDenominator(),f2.getNumerator() * f1.getDenominator() + f2.getDenominator() * f1.getNumerator());
    }

    /**
     * 减法
     */
    public static Fraction sub(Fraction f1, Fraction f2) {
        return new Fraction(f2.getDenominator() * f1.getDenominator(), f2.getDenominator() * f1.getNumerator() - f2.getNumerator() * f1.getDenominator());
    }

    /**
     * 分数的乘法运算
     */
    public static Fraction multiplication(Fraction f1, Fraction f2) { // 乘法运算
        return new Fraction(f2.getDenominator() * f1.getDenominator(),f2.getNumerator() * f1.getNumerator());
    }

    /**
     * 分数除法运算
     */
    public static Fraction div(Fraction f1, Fraction f2) {
        return new Fraction(f2.getNumerator() * f1.getDenominator(),f2.getDenominator() * f1.getNumerator());
    }

    /**
     * 带分数转化为Fraction对象
     * @param properFraction 带分数
     * @return Fraction
     */
    public static Fraction Transform(String properFraction,boolean type){

        if (type) {
            return new Fraction(1,Integer.parseInt(properFraction));
        } else {
            String[] split = properFraction.split("'");
            int denominator;
            int numerator;
            if (split.length == 1) {
                // 普通分数
                split = properFraction.split("/");
                denominator = Integer.parseInt(split[1]);
                numerator = Integer.parseInt(split[0]);

            } else {
                String[] split1 = split[1].split("/");
                denominator = Integer.parseInt(split1[1]);
                numerator = Integer.parseInt(split[0]) * denominator + Integer.parseInt(split1[0]);
            }

            Fraction fraction = new Fraction();
            fraction.setDenominator(denominator);
            fraction.setNumerator(numerator);

            return fraction;
        }
    }


}
