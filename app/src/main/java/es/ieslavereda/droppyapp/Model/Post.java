package es.ieslavereda.droppyapp.Model;

import android.net.Uri;

import java.util.List;

import es.ieslavereda.droppyapp.Utils.Generator;

public class Post {

    private String idPost;
    private String idPoster;
    private String idDrop;
    private Uri photo;
    private List<Like> likes;

    public Post(String idPoster, String idDrop, Uri photo, List<Like> likes) {
        this.idPost = Generator.generatePostId();
        this.idPoster = idPoster;
        this.idDrop = idDrop;
        this.photo = photo;
        this.likes = likes;
    }

    public String getIdPost() {
        return idPost;
    }

    public void setIdPost(String idPost) {
        this.idPost = idPost;
    }

    public String getIdPoster() {
        return idPoster;
    }

    public void setIdPoster(String idPoster) {
        this.idPoster = idPoster;
    }

    public String getIdDrop() {
        return idDrop;
    }

    public void setIdDrop(String idDrop) {
        this.idDrop = idDrop;
    }

    public Uri getPhoto() {
        return photo;
    }

    public void setPhoto(Uri photo) {
        this.photo = photo;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }
}
