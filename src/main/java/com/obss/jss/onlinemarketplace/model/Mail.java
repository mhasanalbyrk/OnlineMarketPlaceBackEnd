package com.obss.jss.onlinemarketplace.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mail {
    private String recipient;
    private String subject;
    private String message;

}
