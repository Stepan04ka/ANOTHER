import java.lang.Math;
import java.util.Scanner;

public class QuadraticEquation {
    
    public QuadraticEquation() {
    }
    
    public QuadraticEquation(double a, double b , double c) {
        this.d = (b*2*2) - 4 * a * c;
        d_sqpt = Math.sqrt(this.d);
        double x1 = -b - d_sqpt/2*a;
        double x2 = -b + d_sqpt/2*a;
        double final_x1 = Math.ceil(x1);
        double final_x2 = Math.ceil(x2);
        System.out.println("Первый корень - " + final_x1 + "\nВторой корень - " + final_x2);
    }
    
    // user nums
    public double user_a;
    public double user_b;
    public double user_c;
    
    // for standart method
    public double d_sqpt;
    public double a;
    public double b;
    public double c;
    public double d;
    
    // for vioeta theoreme
    public double p;
    public double q;
    
    public void VioetaTheoremeSolving() {
        
        p = this.b/this.a;
        q = this.c/this.a;
        
        double another_x1 = -p;
        double another_x2 = q;
        System.out.println(another_x1 + " - первый корень. \n" + another_x2 + " - второй корень. \n");
    }
    
    public void StandartTheoremeSolving() {
        this.d = (this.b*2*2) - 4 * this.a * this.c;
        if (this.d > 0) {
            
            d_sqpt = Math.sqrt(this.d);
            double x1 = -b - d_sqpt/2*a;
            double x2 = -b + d_sqpt/2*a;
            double final_x1 = Math.ceil(x1);
            double final_x2 = Math.ceil(x2);
            
            System.out.println(final_x1 + " - первый корень. \n" + final_x2 + " - второй корень. \n");
        } else if (this.d == 0) {
            
            double one_x = -this.b /2*this.a;
            System.out.println("У уравнения единственный корень , х = " + one_x);
        } else if (this.d <= -1) {
            System.out.println("У уравнения нет корней.");
        }
    }
    
    public void solve() {
        Scanner in = new Scanner(System.in);
        own_cikl: while (true) {
            
            in_cikl: while (true) {
                
                System.out.println("Введите a, b и с: ");
                try {
                    user_a = in.nextDouble();
                    user_b = in.nextDouble();
                    user_c = in.nextDouble();
                }
                
                catch(java.util.InputMismatchException ex) {
                    break own_cikl;
                }
                
                this.a = user_a;
                this.b = user_b;
                this.c = user_c;
                
                if (user_a == 0 ) break own_cikl; break in_cikl;
            }
            
            System.out.println("Выберите ,по какой теореме вы будете решать : \n1. Обычный способом \n2. По теореме виета\n\nОтвет введите здесь: ");
            int UserAnswerForTheoreme = in.nextInt();
            
            switch (UserAnswerForTheoreme) {
                case 1: StandartTheoremeSolving(); break;
                case 2: VioetaTheoremeSolving(); break;
            }
        }
    }
}
