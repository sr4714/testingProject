import axios from 'axios';

const PHOTOS_REST_API_URL = "http://localhost:8080/api/file";

class AddPhotoService {
    createPhoto(photo) {
        return axios.post(PHOTOS_REST_API_URL, photo);
    }
}

export default new AddPhotoService()