import { BrowserRouter, Routes, Route } from "react-router-dom";
import Navbar from "../components/Navbar";
import Footer from "../components/Footer";
import Home from "../pages/Home";
import JourneyModule from "../pages/JourneyModule";
import Livro from "../pages/Livro";
import Jogo from "../pages/Jogo";
import Login from "../pages/Login";
import AdminDashboard from "../pages/AdminDashboard";
import CategoriasAdmin from "../pages/CategoriasAdmin";
import ConteudosAdmin from "../pages/ConteudosAdmin";

function AppRoutes() {
  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/trilha/:slug" element={<JourneyModule />} />
        <Route path="/livro" element={<Livro />} />
        <Route path="/jogo" element={<Jogo />} />
        <Route path="/Login" element={<Login />} />
        <Route path="/AdminDashboard" element={<AdminDashboard />} />
        <Route path="/CategoriasAdmin" element={<CategoriasAdmin />} />
        <Route path="/ConteudosAdmin" element={<ConteudosAdmin />} />
      </Routes>
      <Footer />
    </BrowserRouter>
  );
}

export default AppRoutes;