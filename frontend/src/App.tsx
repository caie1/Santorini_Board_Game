import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import "./App.css";
import Home from "./components/Home";
import PlayerForm from "./components/PlayerForm";
import GameBoard from "./components/GameBoard";
import WinGame from "./components/WinGame";

const App = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/playerform" element={<PlayerForm />} />
        <Route path="/gameboard" element={<GameBoard />} />
        <Route path="/wingame" element={<WinGame />} />
      </Routes>
    </BrowserRouter>
  );
};

export default App;
