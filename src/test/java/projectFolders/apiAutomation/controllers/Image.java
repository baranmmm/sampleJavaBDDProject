package projectFolders.apiAutomation.controllers;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Image {
    private String id;
    private int width;
    private int height;
    private String url;
}
