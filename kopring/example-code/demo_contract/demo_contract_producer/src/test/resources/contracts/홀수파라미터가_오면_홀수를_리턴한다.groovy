import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("홀수를 요청하면 홀수를 응답해야 한다")
    request {
        method GET()
        url("/producer/even-odd"){
            queryParameters {
                parameter("number", "1")
            }
        }
    }
    response {
        body("Odd")
        status(200)
    }
}