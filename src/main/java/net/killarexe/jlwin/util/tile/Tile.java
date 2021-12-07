package net.killarexe.jlwin.util.tile;

import net.killarexe.jlwin.file.Image;

import java.util.List;

public class Tile {
    private int imagesWidth;
    private int imagesHeight;
    private List<Image> images;

    public Tile(int imagesWidth, int imagesHeight, List<Image> images) {
        this.imagesWidth = imagesWidth;
        this.imagesHeight = imagesHeight;
        this.images = images;
    }

    public int getImagesWidth() {
        return imagesWidth;
    }

    public void setImagesWidth(int imagesWidth) {
        this.imagesWidth = imagesWidth;
    }

    public int getImagesHeight() {
        return imagesHeight;
    }

    public void setImagesHeight(int imagesHeight) {
        this.imagesHeight = imagesHeight;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
