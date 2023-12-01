import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("짝수를 요청하면 짝수를 응답해야 한다")
    request {
        method GET()
        url("/producer/even-odd"){
            queryParameters {
                parameter("number", "2")
            }
        }
    }
    response {
        body("Even")
        status(200)
    }
}