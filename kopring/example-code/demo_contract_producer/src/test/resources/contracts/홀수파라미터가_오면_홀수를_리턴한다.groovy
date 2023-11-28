import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("홀수를 요청하면 홀수를 응답해야함")
    request {
        method GET()
        url("/validate/prime-number"){
            queryParameters {
                parameter("number", "1")
            }
        }
    }
    response {
        body("Odd")
        status 200
    }
}