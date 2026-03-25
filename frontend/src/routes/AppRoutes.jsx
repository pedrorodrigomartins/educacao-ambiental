import { BrowserRouter, Routes, Route } from "react-router-dom";
import Navbar from "../components/Navbar";
import Footer from "../components/Footer";
import Home from "../pages/Home";
import Livro from "../pages/Livro";
import Jogo from "../pages/Jogo";
import Home from "./pages/Home";
import Login from "./pages/Login";
import AdminDashboard from "./pages/AdminDashboard";
import CategoriasAdmin from "./pages/CategoriasAdmin";
import ConteudosAdmin from "./pages/ConteudosAdmin";
import PrivateRoute from "./components/PrivateRoute";

function AppRoutes() {
  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/livro" element={<Livro />} />
        <Route path="/jogo" element={<Jogo />} />
        <Route path="/Login" element={<Login />} />
        <Route path="/AdminDashboard" element={<AdminDashboard />} />
        <Route path="/CategoriasAdmin" element={<CategoriasAdmin />} />
        <Route path="/ConteudosAdmin" element={<ConteudosAdmin />} />
        <Route path="/PrivateRoute" element={<PrivateRoute />} />
      </Routes>
      <Footer />
    </BrowserRouter>
  );
}

export default AppRoutes;