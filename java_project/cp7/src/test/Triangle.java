package test;

public class Triangle {

    //변수 : 밑변, 높이
    int width;
    int height;

    //생성자 : 인스턴스 생성시에 반드시 한번 실행 ->  인스턴스 변수들의 초기화 작업
    // 생략가능 ( default contructor)

    //기본 생성자
    Triangle(){

    }

    Triangle(int w, int h){
        width = w;
        height = h;
    }

    //밑변과 높이 데이터를 변경하는 메서드
    void setData(int w, int h){
        width=w;
        height=h;
    }

    //삼각형의 넓이를 구해서 반환하는 메서드

    float area(){
        float result = width*height/2f;
        return result;
    }

    public static void main(String[] args) {
        //삼각형 객체 생성
        //Triangle t = new Triangle();
        Triangle t = new Triangle(7,10);

        System.out.println(t.area());
    }
}
