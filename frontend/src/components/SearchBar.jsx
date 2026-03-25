function SearchBar({ value, onChange }) {
  return (
    <input
      type="text"
      placeholder="Pesquisar categoria..."
      value={value}
      onChange={onChange}
      className="search-bar"
    />
  );
}

export default SearchBar;