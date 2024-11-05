# 1. Mapping
- - -
## 1.1. 정의
- 요청 URL과 특정 메서드, 컨트롤러를 연결하는 과정

## 1.2. 주요 어노테이션
1. @RequestMapping(Class Level)
2. @GetMapping(method level)
3. @PostMapping 
4. @PutMapping 
5. @DeleteMapping

## 1.3. Media Type 설정에서 Consumes vs Produces
### 1.3.1. Consumes
- 클라이언트가 요청할 때 보내는 데이터 형식을 지정

### 1.3.2. Produces
- 서버가 응답을 반환하는 데이터 형식을 지정

# 2. Handler
- - -
## 2.1. 정의
- 요청을 처리하는 메서드나 컨트롤러를 지칭