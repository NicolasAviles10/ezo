
const BASE_URL = 'http://localhost:8080/api'; 

async function request(endpoint, method = 'GET', body = null, token = null) {
  const headers = { 'Content-Type': 'application/json' };
  if (token) headers['Authorization'] = `Bearer ${token}`;

  const config = { method, headers };
  if (body) config.body = JSON.stringify(body);

  try {
    const response = await fetch(`${BASE_URL}${endpoint}`, config);
    const data = await response.json();

    if (!response.ok) {
      throw new Error(data.error || `Error ${response.status}`);
    }
    return data;
  } catch (error) {
    console.error(`[API] ${method} ${endpoint}:`, error.message);
    throw error;
  }
}


export const UsuarioService = {
  getAll: () => request('/usuarios'),

  getById: (id) => request(`/usuarios/${id}`),

  crear: (datos) => request('/usuarios', 'POST', datos),

  actualizar: (id, datos) => request(`/usuarios/${id}`, 'PUT', datos),

  eliminar: (id) => request(`/usuarios/${id}`, 'DELETE'),
};


export const ArticuloService = {
  getAll: (filtros = {}) => {
    const query = new URLSearchParams(filtros).toString();
    return request(`/articulos${query ? '?' + query : ''}`);
  },

  getById: (id) => request(`/articulos/${id}`),

  crear: (datos, token) => request('/articulos', 'POST', datos, token),
};

export const CopiaService = {
  getAll: (filtros = {}) => {
    const query = new URLSearchParams(filtros).toString();
    return request(`/copias${query ? '?' + query : ''}`);
  },

  getById: (id) => request(`/copias/${id}`),

  crear: (datos, token) => request('/copias', 'POST', datos, token),
};

export const IntercambioService = {
  getAll: () => request('/intercambios'),

  getById: (id) => request(`/intercambios/${id}`),

  /**
   * Propone un nuevo intercambio.
   * @param {object} datos - { idUsuarioOrigen, idUsuarioDestino, copiasOfrecidas[], copiassolicitadas[] }
   * @param {string} token - JWT del usuario autenticado
   */
  proponer: (datos, token) => request('/intercambios', 'POST', datos, token),

  /**
   * Actualiza el estado de un intercambio.
   * @param {number} id
   * @param {{ estado: 'ACEPTADO'|'RECHAZADO'|'COMPLETADO' }} datos
   */
  actualizarEstado: (id, datos, token) => request(`/intercambios/${id}`, 'PUT', datos, token),

  cancelar: (id, token) => request(`/intercambios/${id}`, 'DELETE', null, token),
};

export const WishlistService = {
  getMiLista: (idUsuario) => request(`/wishlist?idUsuario=${idUsuario}`),

  agregar: (datos, token) => request('/wishlist', 'POST', datos, token),

  eliminar: (id, token) => request(`/wishlist/${id}`, 'DELETE', null, token),
};

export const MensajeService = {
  getConversacion: (idEmisor, idReceptor) =>
    request(`/mensajes?emisor=${idEmisor}&receptor=${idReceptor}`),

  enviar: (datos, token) => request('/mensajes', 'POST', datos, token),
};
