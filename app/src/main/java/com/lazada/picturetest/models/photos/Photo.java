
package com.lazada.picturetest.models.photos;

import java.util.List;

public class Photo {

    private int id;
    private int userId;
    private String name;
    private Object description;
    private Object camera;
    private Object lens;
    private Object focalLength;
    private Object iso;
    private Object shutterSpeed;
    private Object aperture;
    private int timesViewed;
    private double rating;
    private int status;
    private String createdAt;
    private int category;
    private Object location;
    private Object latitude;
    private Object longitude;
    private Object takenAt;
    private int hiResUploaded;
    private boolean forSale;
    private int width;
    private int height;
    private int votesCount;
    private int favoritesCount;
    private int commentsCount;
    private boolean nsfw;
    private int salesCount;
    private Object forSaleDate;
    private double highestRating;
    private String highestRatingDate;
    private int licenseType;
    private int converted;
    private int collectionsCount;
    private int cropVersion;
    private boolean privacy;
    private boolean profile;
    private String image_url;
    private List<Image> images = null;
    private String url;
    private int positiveVotesCount;
    private int convertedBits;
    private boolean storeDownload;
    private boolean storePrint;
    private boolean storeLicense;
    private boolean requestToBuyEnabled;
    private boolean licenseRequestsEnabled;
    private boolean watermark;
    private String imageFormat;
    private User user;
    private boolean licensingRequested;
    private boolean licensingSuggested;
    private boolean isFreePhoto;
    private int storeWidth;
    private int storeHeight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Object getCamera() {
        return camera;
    }

    public void setCamera(Object camera) {
        this.camera = camera;
    }

    public Object getLens() {
        return lens;
    }

    public void setLens(Object lens) {
        this.lens = lens;
    }

    public Object getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(Object focalLength) {
        this.focalLength = focalLength;
    }

    public Object getIso() {
        return iso;
    }

    public void setIso(Object iso) {
        this.iso = iso;
    }

    public Object getShutterSpeed() {
        return shutterSpeed;
    }

    public void setShutterSpeed(Object shutterSpeed) {
        this.shutterSpeed = shutterSpeed;
    }

    public Object getAperture() {
        return aperture;
    }

    public void setAperture(Object aperture) {
        this.aperture = aperture;
    }

    public int getTimesViewed() {
        return timesViewed;
    }

    public void setTimesViewed(int timesViewed) {
        this.timesViewed = timesViewed;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public Object getLocation() {
        return location;
    }

    public void setLocation(Object location) {
        this.location = location;
    }

    public Object getLatitude() {
        return latitude;
    }

    public void setLatitude(Object latitude) {
        this.latitude = latitude;
    }

    public Object getLongitude() {
        return longitude;
    }

    public void setLongitude(Object longitude) {
        this.longitude = longitude;
    }

    public Object getTakenAt() {
        return takenAt;
    }

    public void setTakenAt(Object takenAt) {
        this.takenAt = takenAt;
    }

    public int getHiResUploaded() {
        return hiResUploaded;
    }

    public void setHiResUploaded(int hiResUploaded) {
        this.hiResUploaded = hiResUploaded;
    }

    public boolean isForSale() {
        return forSale;
    }

    public void setForSale(boolean forSale) {
        this.forSale = forSale;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getVotesCount() {
        return votesCount;
    }

    public void setVotesCount(int votesCount) {
        this.votesCount = votesCount;
    }

    public int getFavoritesCount() {
        return favoritesCount;
    }

    public void setFavoritesCount(int favoritesCount) {
        this.favoritesCount = favoritesCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public boolean isNsfw() {
        return nsfw;
    }

    public void setNsfw(boolean nsfw) {
        this.nsfw = nsfw;
    }

    public int getSalesCount() {
        return salesCount;
    }

    public void setSalesCount(int salesCount) {
        this.salesCount = salesCount;
    }

    public Object getForSaleDate() {
        return forSaleDate;
    }

    public void setForSaleDate(Object forSaleDate) {
        this.forSaleDate = forSaleDate;
    }

    public double getHighestRating() {
        return highestRating;
    }

    public void setHighestRating(double highestRating) {
        this.highestRating = highestRating;
    }

    public String getHighestRatingDate() {
        return highestRatingDate;
    }

    public void setHighestRatingDate(String highestRatingDate) {
        this.highestRatingDate = highestRatingDate;
    }

    public int getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(int licenseType) {
        this.licenseType = licenseType;
    }

    public int getConverted() {
        return converted;
    }

    public void setConverted(int converted) {
        this.converted = converted;
    }

    public int getCollectionsCount() {
        return collectionsCount;
    }

    public void setCollectionsCount(int collectionsCount) {
        this.collectionsCount = collectionsCount;
    }

    public int getCropVersion() {
        return cropVersion;
    }

    public void setCropVersion(int cropVersion) {
        this.cropVersion = cropVersion;
    }

    public boolean isPrivacy() {
        return privacy;
    }

    public void setPrivacy(boolean privacy) {
        this.privacy = privacy;
    }

    public boolean isProfile() {
        return profile;
    }

    public void setProfile(boolean profile) {
        this.profile = profile;
    }

    public String getImageUrl() {
        return image_url;
    }

    public void setImageUrl(String imageUrl) {
        this.image_url = imageUrl;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPositiveVotesCount() {
        return positiveVotesCount;
    }

    public void setPositiveVotesCount(int positiveVotesCount) {
        this.positiveVotesCount = positiveVotesCount;
    }

    public int getConvertedBits() {
        return convertedBits;
    }

    public void setConvertedBits(int convertedBits) {
        this.convertedBits = convertedBits;
    }

    public boolean isStoreDownload() {
        return storeDownload;
    }

    public void setStoreDownload(boolean storeDownload) {
        this.storeDownload = storeDownload;
    }

    public boolean isStorePrint() {
        return storePrint;
    }

    public void setStorePrint(boolean storePrint) {
        this.storePrint = storePrint;
    }

    public boolean isStoreLicense() {
        return storeLicense;
    }

    public void setStoreLicense(boolean storeLicense) {
        this.storeLicense = storeLicense;
    }

    public boolean isRequestToBuyEnabled() {
        return requestToBuyEnabled;
    }

    public void setRequestToBuyEnabled(boolean requestToBuyEnabled) {
        this.requestToBuyEnabled = requestToBuyEnabled;
    }

    public boolean isLicenseRequestsEnabled() {
        return licenseRequestsEnabled;
    }

    public void setLicenseRequestsEnabled(boolean licenseRequestsEnabled) {
        this.licenseRequestsEnabled = licenseRequestsEnabled;
    }

    public boolean isWatermark() {
        return watermark;
    }

    public void setWatermark(boolean watermark) {
        this.watermark = watermark;
    }

    public String getImageFormat() {
        return imageFormat;
    }

    public void setImageFormat(String imageFormat) {
        this.imageFormat = imageFormat;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isLicensingRequested() {
        return licensingRequested;
    }

    public void setLicensingRequested(boolean licensingRequested) {
        this.licensingRequested = licensingRequested;
    }

    public boolean isLicensingSuggested() {
        return licensingSuggested;
    }

    public void setLicensingSuggested(boolean licensingSuggested) {
        this.licensingSuggested = licensingSuggested;
    }

    public boolean isIsFreePhoto() {
        return isFreePhoto;
    }

    public void setIsFreePhoto(boolean isFreePhoto) {
        this.isFreePhoto = isFreePhoto;
    }

    public int getStoreWidth() {
        return storeWidth;
    }

    public void setStoreWidth(int storeWidth) {
        this.storeWidth = storeWidth;
    }

    public int getStoreHeight() {
        return storeHeight;
    }

    public void setStoreHeight(int storeHeight) {
        this.storeHeight = storeHeight;
    }

}
