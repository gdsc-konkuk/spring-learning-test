# 요기다 정리
` @ResponseStatus `:응답 상태 지정가능
```  
@RequestParam(required = false) String name,
@RequestHeader(value = "HEADER", required = false) String header
```
required를 통해, 값이 필수인지를 정할 수 있음.
값이 필수가 아닐때, 해당 값이 안들어온경우 null을 반환함.
분기를 나눠서, 케이스를 나눠 처리 가능,`HttpMethodController`처럼.

MediaType.APPLICATION_JSON_VALUE 와
MediaType.TEXT_HTML_VALUE 를 통해
반환 형식별로 지정해서 사용