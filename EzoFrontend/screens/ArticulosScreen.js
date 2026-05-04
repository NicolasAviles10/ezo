import React, { useEffect, useState } from 'react';
import { View, Text, FlatList, StyleSheet, ActivityIndicator, RefreshControl, TouchableOpacity } from 'react-native';
import { ArticuloService } from '../services/ApiService';

export default function ArticulosScreen() {
  const [articulos, setArticulos] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  async function cargar() {
    setLoading(true); setError(null);
    try {
      const data = await ArticuloService.getAll();
      setArticulos(Array.isArray(data) ? data : [data]);
    } catch (err) { setError(err.message); }
    finally { setLoading(false); }
  }

  useEffect(() => { cargar(); }, []);

  if (loading) return <ActivityIndicator style={styles.center} size="large" color="#e94560" />;
  if (error)   return <Text style={styles.error}>Error: {error}</Text>;

  return (
    <FlatList
      style={styles.lista}
      data={articulos}
      keyExtractor={(item, i) => String(item.id_articulo ?? i)}
      refreshControl={<RefreshControl refreshing={loading} onRefresh={cargar} tintColor="#e94560" />}
      renderItem={({ item }) => (
        <TouchableOpacity style={styles.tarjeta}>
          <Text style={styles.nombre}>{item.nombre ?? item.mensaje ?? 'Articulo'}</Text>
          {item.precio && <Text style={styles.precio}>Bs. {item.precio}</Text>}
          {item.tipo   && <Text style={styles.tipo}>{item.tipo}</Text>}
        </TouchableOpacity>
      )}
    />
  );
}

const styles = StyleSheet.create({
  lista:   { backgroundColor: '#1a1a2e', flex: 1, padding: 12 },
  center:  { flex: 1, justifyContent: 'center' },
  error:   { color: '#e94560', textAlign: 'center', marginTop: 20 },
  tarjeta: { backgroundColor: '#16213e', borderRadius: 10, padding: 16, marginBottom: 12 },
  nombre:  { color: '#fff', fontSize: 16, fontWeight: 'bold' },
  precio:  { color: '#e94560', marginTop: 4, fontWeight: '600' },
  tipo:    { color: '#aaa', marginTop: 2, fontSize: 12 },
});
