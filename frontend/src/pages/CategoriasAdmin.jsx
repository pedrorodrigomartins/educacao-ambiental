import { useEffect, useState } from "react";
import api from "../services/api";

function CategoriasAdmin() {
  const [categorias, setCategorias] = useState([]);
  const [nome, setNome] = useState("");
  const [descricao, setDescricao] = useState("");

  const token = localStorage.getItem("token");

  async function carregarCategorias() {
    const response = await api.get("/categorias");
    setCategorias(response.data);
  }

  async function criarCategoria(e) {
    e.preventDefault();

    await api.post(
      "/categorias",
      { nome, descricao },
      {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      }
    );

    setNome("");
    setDescricao("");
    carregarCategorias();
  }

  async function deletarCategoria(id) {
    await api.delete(`/categorias/${id}`, {
      headers: {
        Authorization: `Bearer ${token}`,
      },
    });

    carregarCategorias();
  }

  useEffect(() => {
    carregarCategorias();
  }, []);

  return (
    <div>
      <h1>Categorias</h1>

      <form onSubmit={criarCategoria}>
        <input
          type="text"
          placeholder="Nome"
          value={nome}
          onChange={(e) => setNome(e.target.value)}
        />
        <input
          type="text"
          placeholder="Descrição"
          value={descricao}
          onChange={(e) => setDescricao(e.target.value)}
        />
        <button type="submit">Criar</button>
      </form>

      <ul>
        {categorias.map((categoria) => (
          <li key={categoria.id}>
            {categoria.nome} - {categoria.descricao}
            <button onClick={() => deletarCategoria(categoria.id)}>Excluir</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default CategoriasAdmin;