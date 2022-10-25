# 데이터 조회하기 with JPA

(오늘의 만들 부분)
<img src="http://drive.google.com/uc?export=view&id=1dv5vKzpuW2jlkApyEAYOeFUgo3x-JZQC">
```
DB속 데이터를 조회하여 웹 페이지로 확인하시오
```

### @PathVariable?
- REST API에서 URL에 변수가 들어가는걸 실무에서 많이 볼수 있는데
예를 들면, 아래 URL에서 밑줄 친 부분이 @PathVariable로 처리해줄 수 있는 부분이다.
- http://localhost:8080/api/user/1234

`사용법`
```java
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {

	@GetMapping("/user/{userName}")
	public String user(@PathVariable String userName){
		System.out.println(userName);
		return "index";
	}
}
```
이처럼 @PathVariable 은 메서드 인자에 사용되어 URI 템플릿 변수의 값을 메서드 인자로 할당하는데 사용된다.