package edu.kh.poly.ex1.model.service;

import edu.kh.poly.ex1.model.vo.Car;
import edu.kh.poly.ex1.model.vo.Spark;
import edu.kh.poly.ex1.model.vo.Tesla;

public class PolyService {
	
	public void ex1() {
		//다형성 확인예제
		
		//Car 객체 생성
		Car car = new Car();
		//부모타입 참조변수=부모객체
		
		//tesla 객체생성
		Tesla tesla = new Tesla();
		//자식 타입 참조변수= 자식객체
		
		//************다형성******
		Car car2 = new Tesla();
		//Tesla 객체를 참조하는 변수의 타입이 Car(부모)이기 때문에
		//Tesla 객체가 Car(부모) 객체로 변화함
		
		Car car3 = new Spark();
		
		//부모타입 참조변수 = 자식객체
		
		// **********다형성(업캐스팅)방법
		// 1)자식객체가 부모객체로 변하였기때문에
		// 자식망의 고유한필드. 메소드를 사용할수없다
		
		// 1-1)car(부모=부모)
		car.setEngine("v6");
		car.setFuel("휘발유");
		car.setWheel(4);

		//car 메소드 모두 사용가능
		
		//1-2)tesla (자식=자식)
		tesla.setEngine("전기모터");
		tesla.setFuel("전기");
		tesla.setWheel(4);
		tesla.setBatteryCapacity(10000);
		
		//1-3   car2 (부모=자식)
		car2.setEngine("전기모터");
		car2.setFuel("전기");
		car2.setWheel(4);
		//car2.setBatteryCapacity(10000);  //에러
		
		
		
		car3.setEngine("경차엔진");
		car3.setFuel("휘발유");
		car3.setWheel(4);
		//car3.setBatteryCapacity(10000);
		
		
		//----------------------------------
		
		//2)다형성을 이용한 객체 배열
		
		//객체배열: 같은 객체 참조 자료형변수를 하나의 묶음으로 다루는것
		            //부모타입 참조자료형의 변수를 하나의 묶음으로 다루는것

		Car[] arr= new Car[3]; //부모타입 참조변수 배열 선언및할당
		//각 배열요소가 Car 타입 참조변수
		
		arr[0]=car; //Car 주소
		arr[1]=car2; //Tesla 주소
		arr[2]=car3; // Spark 주소
		
		
		for(int i=0; i<arr.length;i++) {
			System.out.println(i+"번째 인덱스의 엔진"+ arr[i].getEngine());
			
		}
		//상속 + 다형성
		//상속특징: Car 상속 클래스는 모두 getEngine()을 가지고 있다정의
		//다형성 (업캐스팅): 부모타입 참조변수arr[i]로 자식객체를 참조항수있다
		
	
	}
	
	public void ex2() {
		//2)다형성 (업캐스팅)을 이용한 매개변수 사용법
		Tesla t = new Tesla("전기모터","전기",4,1000000);
		
		Spark s = new Spark("경차엔진","휘발유",4,0.5);
		
		Car c =new Car("경유엔진","경유",12);
		
		printCar(t);
		printCar(s);
		printCar(c);
		
		System.out.println("==================");
		
		//4)다형성을 이용한 변환형 사용법
//		Car[] arr = {new Car(), new Tesla(),new Spark()};
		
		Car[] arr = {createCar(1),createCar(2),createCar(3)};
					//Car		//Car			//Car
								//Tesla			//Spark
		//arr[0]; //Car
		//arr[1]; //Tesla
		//arr[2]; ///Spark
		
		//instanceof 연산자: 객체의 자료형을 검사하는 연산자
		//참조하는 객체가 특정 자료형이나 부모쪽 상속관계인지 확인
		
		System.out.println(arr[1]instanceof Tesla);//true
		System.out.println(arr[1]instanceof Spark);//false
		System.out.println(arr[1]instanceof Car);//true
	}
	
	//전달받은 Car 또는 자식 객체의 엔진,연료,바퀴수출력하는 메서드
	//매개변수에 부모타입 참조변수를 작성하면 모든 자식 객체를 전달받을수있다
	public void printCar(Car temp) {
		//부모타입 참조변수 =자식타입객체
		//다형성의 업캐스팅 모양과 같다
		//temp에는 Tesla,Spark,car의 주소가 넘어와도된다(업캐스팅
		System.out.println("엔진:"+temp.getEngine());
		System.out.println("연료:"+temp.getFuel());
		System.out.println("바퀴개수:"+temp.getWheel());
		System.out.println();
	}
		
		
		
		public Car createCar(int num){
			Car result = null;
			
			switch(num) {
			case 1 : result = new Car();break;
			case 2 : result = new Tesla();break;
			case 3 : result = new Spark();break;
			}
			return result;
			
	}
}
