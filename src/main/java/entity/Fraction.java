package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author zjz
 * @date 2023/9/23
 */
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Fraction {

    /**
     * 分母默认为1
     */
    private int denominator;
    /**
     * 分子
     */
    private int numerator;

    /**
     * 用辗转相除法求最大公约数
     * @param a 被除数
     * @param b 除数
     * @return 最大公约数
     */
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    /**
     * 对分数进行约分
     */
    public void Appointment() {
        if (numerator == 0 || denominator == 1)
            return;
        // 如果分子是0或分母是1就不用约分了
        int gcd = gcd(numerator, denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
    }

    public  String transferFraction(){//对分数进行约分化简
        if (this.denominator == 0) this.denominator = 1;
        int c = this.numerator/gcd(this.numerator,this.denominator);
        int d = this.denominator/gcd(this.numerator,this.denominator);
        int e = c/d;
        int f = c%d;
        String str = "";
        if(f==0){
            str += e;
        }else if(e!=0){
            str = e+"'"+f+"/"+d;
        }else{
            str +=f+"/"+d ;
        }
        return str;
    }


    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
