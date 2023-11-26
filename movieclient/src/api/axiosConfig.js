import axios from 'axios';

export default axios.create({
    baseURL:'https://b4ef-119-161-98-68.ngrok-free.app',
    headers: {"ngrok-skip-browser-warning": "true"}
});