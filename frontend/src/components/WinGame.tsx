import santoriniImg from "./../assets/pic3283110.webp";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const WinGame = () => {
  const navigate = useNavigate();
  const startGame = () => {
    var config = {
      method: "get",
      url: "http://localhost:8080",
      headers: {},
    };

    axios(config)
      .then(function (response) {
        if (response.data == "Hello world") {
          navigate("/playerForm");
        } else {
          alert("Not connected to backend");
        }
      })
      .catch(function (error) {
        alert("Not connected to backend");
        console.log(error);
      });
  };

  return (
    <div className="d-flex flex-column">
      <h1 className="mx-auto mb-auto p-3 bd-highlight">
        Congradulation for Winning the Game!!!
      </h1>

      <img className="mx-auto m-3 w-30" src={santoriniImg} />

      <button
        onClick={startGame}
        className="btn btn-primary mx-auto mt-2 mb-5 w-8"
      >
        Click Me to Start Another Game
      </button>
    </div>
  );
};

export default WinGame;
