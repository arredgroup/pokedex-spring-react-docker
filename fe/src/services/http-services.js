import axios from "axios";

export default axios.create({
    baseURL: "http://35.232.192.5:8080/api/pokemon",
    headers: {
        "Content-type": "application/json"
    }
});