package com.example.demo.di4;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.google.common.reflect.ClassPath;

//@Component class Car{
//	@Autowired Engine engine;
//	@Autowired Door door;
//	
//	@Override
//	public String toString() {
//		return String.format("Car[engine = %s, door = %s]", engine, door);
//	}
//};
//@Component class SportCar extends Car{};
//@Component class Truck extends Car{};
//@Component class Engine{};
//@Component class Door{};

// 패키지 전체를 순회하면서 @Componrt 어노테이션이 달린 클래스들을 객체로 컨테이너 저장
// @Autowired가 달린 필드에 컨테이너에 저장되어 있는 객체를 세팅해준다.
class AppContext{
	Map map; // 객체를 저장할 map을 선언
	
	// AppContext 객체가 만들어질 때 HashMap이 같이 만들어진다.
	public AppContext() {
		map = new HashMap();
		doComponentScan(); 
		doAutowired();
	}
	
	// 객체 자동 등록하기
	// Component Scanning
	// 클래스 앞에 @Component 어노테이션을 붙이고
	// 패키지에 컴포넌트 어노테이션이 붙어있는 클래스를 찾아서 객체를 만들고
	// 맵에 저장하는 기법
	private void doComponentScan() {
		try {
			// AppContext 클래스를 찾아 메모리에 올려서 객체를 생성할 수 있는 상태로 만든다.
			ClassLoader classLoder = AppContext.class.getClassLoader();
			
			// 클래스 경로 상의 모든 클래스를 탐색하고 사용할 수 있게 도와준다.
			ClassPath classPath = ClassPath.from(classLoder);
			
			Set<ClassPath.ClassInfo> set = classPath.getTopLevelClasses("com.example.demo.di4");
			
			for(ClassPath.ClassInfo classInfo : set) {
				
				// 현재의 ClassInfo 객체를 실제로 로드된 클래스(Class)로 변환한다.
				Class clazz = classInfo.load();
				
				// 해당 클래스에 @Component가 달려있는지 확인한다.
				Component component = (Component)clazz.getAnnotation(Component.class);
				
				// 해당 클래스가 @Component로 지정된 클래스라면
				if(component != null) {
					// key, value 설정해서 map에 저장해야 한다.
					String id = StringUtils.uncapitalize(classInfo.getSimpleName());
			
					map.put(id, clazz.newInstance());
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void doAutowired() {
		// map에 저장된 객체의 객체변수 중에 @Autowired가 붙어있으면
		// 객체변수의 타입에 맞는 객체를 찾아 연결한다. 
		
		try {
			// map에 들어있는 객체를 하나씩 꺼내서 
			for(Object bean : map.values()) {
				// 객체 안에 있는 멤버변수를 하나씩 꺼내서
				for(Field fld : bean.getClass().getDeclaredFields()) {
					// 하나씩 @Autowired가 붙어있는가 검사
					if(fld.getAnnotation(Autowired.class)!=null) {
						// fld.getType() : 필드의 타입을(Engine.class)
						// fld.set() : 필드에 객체를 주입 car.engine = engine;
						fld.set(bean, getBean(fld.getType()));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	Object getBean(String key) {
		return map.get(key);
	}
	
	// 클래스 정보를 매개변수로 받는다. getBean(Car.class)
	Object getBean(Class clazz) {
		for(Object obj : map.values()) {
			// obj가 clazz 타입의 객체라면 반환
			if(clazz.isInstance(obj)) {
				return obj;
			}
		}
		return null;
	}
}


public class Main4 {
	public static void main(String[] args) {
		// @Component가 붙은 클래스를 객체를 만들어서 컨테이너에 담는다.
		AppContext ac = new AppContext();
		
//		Car car = (Car)ac.getBean("car");
//		System.out.println(car);
		
		// 컨테이너에 들어있는 객체를 꺼낸다.
//		Engine engine = (Engine)ac.getBean("engine");
//		Door door = (Door)ac.getBean("door");
		
		// 필드에 대입 한다.
		// 수동으로 하기 번거로움. 
//		car.engine = engine;
//		car.door = door;
	}
}