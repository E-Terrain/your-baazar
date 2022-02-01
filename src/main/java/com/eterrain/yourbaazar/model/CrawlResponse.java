package com.eterrain.yourbaazar.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

@Builder
@Getter
@Setter
public class CrawlResponse extends ApiResponse {
    public String url;
    public String description;
}
