import { Link, useNavigate } from "react-router-dom";

function AdminDashboard() {
  const navigate = useNavigate();

  function handleLogout() {
    localStorage.removeItem("token");
    navigate("/login");
  }

  return (
    <div>
      <h1>Painel Administrativo</h1>

      <nav>
        <Link to="/admin/categorias">Gerenciar Categorias</Link>
        {" | "}
        <Link to="/admin/conteudos">Gerenciar Conteúdos</Link>
      </nav>

      <button onClick={handleLogout}>Sair</button>
    </div>
  );
}

export default AdminDashboard;