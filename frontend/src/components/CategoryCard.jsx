import { Link } from "react-router-dom";

function CategoryCard({ titulo, descricao, rota }) {
  return (
    <div className="category-card">
      <h3>{titulo}</h3>
      <p>{descricao}</p>
      <Link to={rota}>Acessar</Link>
    </div>
  );
}

export default CategoryCard;