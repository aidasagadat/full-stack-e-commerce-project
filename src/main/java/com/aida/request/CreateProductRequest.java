package com.aida.request;

import java.util.List;
import java.util.Objects;

public class CreateProductRequest {
    private String title;
    private String description;
    private int mrpPrice;
    private int sellingPrice;
    private String color;
    private List<String> images;
    private String category;
    private String category2;
    private String category3;
    private String sizes;

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMrpPrice() {
        return mrpPrice;
    }

    public void setMrpPrice(int mrpPrice) {
        this.mrpPrice = mrpPrice;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory2() {
        return category2;
    }

    public void setCategory2(String category2) {
        this.category2 = category2;
    }

    public String getCategory3() {
        return category3;
    }

    public void setCategory3(String category3) {
        this.category3 = category3;
    }

    public String getSizes() {
        return sizes;
    }

    public void setSizes(String sizes) {
        this.sizes = sizes;
    }

    // toString method
    @Override
    public String toString() {
        return "CreateProductRequest{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", mrpPrice=" + mrpPrice +
                ", sellerPrice=" + sellingPrice +
                ", color='" + color + '\'' +
                ", images=" + images +
                ", category='" + category + '\'' +
                ", category2='" + category2 + '\'' +
                ", categor3y='" + category3 + '\'' +
                ", sizes='" + sizes + '\'' +
                '}';
    }

    // equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateProductRequest that = (CreateProductRequest) o;
        return mrpPrice == that.mrpPrice && sellingPrice == that.sellingPrice && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(color, that.color) && Objects.equals(images, that.images) && Objects.equals(category, that.category) && Objects.equals(category2, that.category2) && Objects.equals(category3, that.category3) && Objects.equals(sizes, that.sizes);
    }

    // hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(title, description, mrpPrice, sellingPrice, color, images, category, category2, category3, sizes);
    }
}
