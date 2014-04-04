package org.hackerpins.business.bean_validation;


import org.hackerpins.business.domain.Media;
import org.hackerpins.business.domain.MediaType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by shekhargulati on 04/04/14.
 */
public class ImageOrVideoSrcUrlValidator implements ConstraintValidator<ImageOrVideoSrcUrl, Media> {

    @Override
    public void initialize(ImageOrVideoSrcUrl constraintAnnotation) {

    }

    @Override
    public boolean isValid(Media media, ConstraintValidatorContext context) {
        if (media == null || media.getMediaUrl() == null) {
            return true;
        }
        String mediaUrl = media.getMediaUrl();
        MediaType mediaType = media.getType();
        switch (mediaType) {
            case PHOTO:
                return mediaUrl.endsWith(".jpg") || mediaUrl.endsWith(".png") || mediaUrl.endsWith(".jpeg");
            case VIDEO:
                return mediaUrl.endsWith(".mp4");
            default:
                return false;
        }
    }
}