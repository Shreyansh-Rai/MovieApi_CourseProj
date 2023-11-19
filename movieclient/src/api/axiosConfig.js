import axios from 'axios';

export default axios.create({
    baseURL:'https://c765-103-156-19-229.ngrok-free.app',
    headers: {"ngrok-skip-browser-warning": "true"}
});