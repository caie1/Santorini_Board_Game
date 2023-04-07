import {
  FC,
  useEffect,
  useState,
} from "react";

interface Props {
  curPlayer: number;
  curPlayerAction: number;
  curPlayerName: string;
  gameWarningState: number;
  gameWarningMessage: string;
}

const GameMessage: FC<Props> = ({
  curPlayer,
  curPlayerAction,
  curPlayerName,
  gameWarningState,
  gameWarningMessage,
}) => {
  // const []
  const [playerNameColor, playerNameColorUpdate] = useState("text-success");
  const [gameWarning, gameWarningUpdate] = useState("");
  const [gameMessage, gameMessageUpdate] = useState(" please the first worker");

  useEffect(() => {
    console.log(curPlayerAction);

    if (curPlayer == 0) {
      playerNameColorUpdate("text-danger");
    } else {
      playerNameColorUpdate("text-success");
    }
    switch (curPlayerAction) {
      case 0:
        gameMessageUpdate(" please place the first worker");
        break;
      case 1:
        gameMessageUpdate(" please place the second worker");
        break;
      case 2:
        gameMessageUpdate(" please select your worker to make a move");
        break;
      case 3:
        gameMessageUpdate(" please select a adjacent grid to move to");
        break;
      case 3.5:
        gameMessageUpdate(", by the power of Hermes, please select a adjacent grid to move to");
        break;
      case 4:
        gameMessageUpdate(" please select a worker to command build");
        break;
      case 4.5:
        gameMessageUpdate(" have the power of Demeter, thus can make another build, please select your worker to build");
        break;
      case 5:
        gameMessageUpdate(" please select a adjacent grid to build on");
        break;
      case 5.5:
        gameMessageUpdate(" please select a adjacent grid to build on, you cannot choose the previous built grid");
        break;
    }
  }, [curPlayer, curPlayerAction]); // <-- here put the parameter to listen

  useEffect(() => {
    switch (gameWarningState) {
      case 0:
        gameWarningUpdate("");
        break;
      case 1:
        gameWarningUpdate(
          "Please select another grid, this grid already have a worker"
        );
        break;
      case 2:
        gameWarningUpdate("You can only move to adjacent grid");
        break;
      case 3:
        gameWarningUpdate("You have to select your own worker");
        break;
    }
  }, [gameWarningState]); // <-- here put the parameter to listen

  useEffect(() => {
    gameWarningUpdate(gameWarningMessage);
  }, [gameWarningMessage]); // <-- here put the parameter to listen

  return (
    <div>
      <div className="row mt-4">
        <div className="col-sm text-warning">{gameWarning}</div>
      </div>

      <div className="row mt-4">
        <div className="col-sm">
          <span className={playerNameColor}>{curPlayerName}</span>
          {gameMessage}
        </div>
      </div>
    </div>
  );
};

export default GameMessage;
