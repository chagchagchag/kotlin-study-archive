package com.example.demo_feign_client.feign.config

import com.example.demo_feign_client.feign.FeignPackageBase
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.context.TypeExcludeFilter
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.FilterType

@TestConfiguration
@ComponentScan(
    basePackageClasses = [FeignPackageBase::class],
    excludeFilters = [
        ComponentScan.Filter(
            type = FilterType.CUSTOM,
            classes = [TypeExcludeFilter::class],
        )
    ]
)
@EnableAutoConfiguration
class FeignJsonPlaceholderTestContextConfiguration {
}