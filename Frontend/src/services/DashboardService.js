import axios from 'axios'

const PHOTOS_REST_API_URL = 'http://localhost:8080/api/file/list';

class PhotoService {

    getPhotos() {
        return axios.get(PHOTOS_REST_API_URL);
    }

    getPhoto(name) {
        return axios.get("http://localhost:8080/api/file/" +name);
    }
}

export default new PhotoService();