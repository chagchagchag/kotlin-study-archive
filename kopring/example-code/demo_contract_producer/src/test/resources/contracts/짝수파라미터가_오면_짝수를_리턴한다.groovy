//package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("짝수를 요청하면 짝수를 응답해야함")
    request {
        method GET()
        url("/validate/prime-number"){
            queryParameters {
                parameter("number", "2")
            }
        }
    }
    response {
        body("Even")
        status 200
    }
}