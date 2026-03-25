import { Link } from "react-router-dom";

function Navbar() {
  return (
    <nav className="navbar">
      <div className="logo">Educação Ambiental</div>

      <div className="nav-links">
        <Link to="/">Home</Link>
        <Link to="/Jogo">Jogo</Link>
        <Link to="/Livro">Livro</Link>
        <Link to="/ConteudosAdmin">Catálago</Link>
        <Link to="/Sobre">Sobre</Link>
      </div>
    </nav>
  );
}

export default Navbar;