package com.xenon.simplyrecipes.views.components;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.server.StreamResource;
import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UploadImage extends Div {

    private static final String FOLDER_PATH = "src/main/resources/META-INF/resources/images/";

    @Getter
    @Setter
    private File file;

    @Getter
    @Setter
    private String originalFileName;

    public UploadImage() {
        Upload upload = createUploadComponent();
        Div output = new Div(new Text("(no image file uploaded yet)"));
        upload.setUploadButton(new Button("Upload Recipe Image"));
        setupUploadListener(upload, output);

        add(upload, output);
    }

    private Upload createUploadComponent() {
        Upload upload = new Upload(this::receiveUpload);
        upload.setMaxFiles(1);
        upload.setDropAllowed(true);
        upload.setDropLabel(new Div(new Text("Receipe image")));
        upload.setAcceptedFileTypes("image/jpeg", "image/jpg", "image/png", "image/gif");
        return upload;
    }

    private void setupUploadListener(Upload upload, Div output) {
        upload.addSucceededListener(event -> {
            output.removeAll();
            Image uploadedImage = getUploadedImage();
            output.add(uploadedImage);
            addRemoveIcon(upload, uploadedImage);
            upload.removeFromParent();
        });
        upload.addFailedListener(event -> {
            output.removeAll();
            output.add(new Text("Upload failed: " + event.getReason()));
        });
    }

    private Image getUploadedImage() {
        Image uploadedImage = new Image(new StreamResource(this.originalFileName, this::loadFile), "Uploaded image");
        uploadedImage.setWidth(100, Unit.PIXELS);
        uploadedImage.setHeight(100, Unit.PIXELS);
        return uploadedImage;
    }

    private void addRemoveIcon(Upload upload, Image uploadedImage) {
        Icon removeIcon = VaadinIcon.CLOSE_SMALL.create();
        removeIcon.setColor("red");
        removeIcon.addClickListener(e -> handleImageRemoval(upload, uploadedImage, removeIcon));
        add(removeIcon);
    }

    private void handleImageRemoval(Upload upload, Image uploadedImage, Icon removeIcon) {
        add(upload);
        removeIcon.removeFromParent();
        uploadedImage.removeFromParent();
    }

    public InputStream loadFile() {
        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException e) {
            logError("Failed to create InputStream for: '" + this.file.getAbsolutePath(), e);
        }
        return null;
    }

    private OutputStream receiveUpload(String originalFileName, String MIMEType) {
        this.originalFileName = originalFileName;
        try {
            this.file = createFile().orElseThrow(() -> new IOException("Failed to receive file"));
            return new FileOutputStream(file);
        } catch (IOException e) {
            logError("Failed to create InputStream for: '" + this.file.getAbsolutePath(), e);
        }

        return null;
    }

    private Optional<File> createFile() throws IOException {
        File file = new File(FOLDER_PATH + originalFileName);
        return file.createNewFile() ? Optional.of(file) : Optional.empty();
    }

    public String getUploadedFilePath() {
        return file != null ? file.getAbsolutePath() : null;
    }

    private void logError(String message, Exception exception) {
        Logger.getLogger(this.getClass().getName()).log(Level.WARNING, message, exception);
    }
}
