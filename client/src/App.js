import React, { useState, useEffect } from "react";
import { Route, Routes } from 'react-router-dom';
import './App.css';
import './Components/Contact/ContactPage.css';
import './Components/About/AboutPage.css';
import Home from './Components/HomePage/Home';
import Form from './Components/Register/Form';
import NavBar from './Components/NavBar/NavBar';
import FootBar from './Components/Footer/FootBar';
import AboutPage from "./Components/About/AboutPage";
import ContactPage from "./Components/Contact/ContactPage";
import ListOfTrainings from "./Components/TrainingComponents/ListOfTrainings";
import Training from "./Components/TrainingComponents/Training";
import Diets from "./Components/DietComponents/Diets";
import DietInfo from "./Components/DietComponents/DietInfo";
import SearchDiets from "./Components/DietComponents/SearchDiets"
import MealInfo from "./Components/DietComponents/MealInfo";
import Profile from "./Components/Profile/Profile";
import Register from "./Components/Register/Register";
import { useNavigate } from 'react-router-dom';
import TrainingFromIcon from "./Components/TrainingComponents/TrainingFromIcon";

function App() {
  const navigate = useNavigate();

  const [tryingToSign, setTryingToSign] = useState(false);


  const [user, setUser] = useState();
  const [jwt, setJwt] = useState()
  const[pickedTraining, setPickedTraining] = useState();

  useEffect(() => {
    document.title = 'Gym Viking: Home';
  }, [])

  return (
    <div>
      <div className="App">
        <header className="App-header">
          <NavBar  tryingToSign={tryingToSign} setTryingToSign={setTryingToSign} setUser={setUser} setJwt={setJwt} user={user}/>
        </header>
        <Routes>
          <Route path='/' element={<Home user={user}/>}></Route>
          <Route path='contact' element={<ContactPage />}></Route>
          <Route path='register' element={<Register/>}></Route>
          <Route path='about' element={<AboutPage />}></Route>
          <Route path='training' element={<Training user={user} setUser={setUser}/>}/>
          <Route path='trainings' element={<ListOfTrainings user={user} setPickedTraining={setPickedTraining}/>}></Route>
          <Route path='trainings/trainingFromList' element={<TrainingFromIcon user={user} training={pickedTraining} setUser={setUser}/>}></Route>
          <Route path='diets' element={<Diets user={user} />}></Route>
          <Route path='diets/search' element={<SearchDiets user={user}/>}></Route>
          <Route path='diets/:index' element={<DietInfo/>}></Route>
          <Route path='meals/:index' element={<MealInfo/>}></Route>
          <Route path='profile' element={<Profile user={user} />}></Route>
          <Route path='form' element={<Form user={user} setUser={setUser} />}></Route>
        </Routes>
          <footer className="App-footer">
            <FootBar user={user}/>
          </footer>
      </div>
    </div>

  );
}

export default App;