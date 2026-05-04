import React, { useState } from 'react';
import { View, Text, TextInput, TouchableOpacity, StyleSheet, Alert, ActivityIndicator } from 'react-native';
import { UsuarioService } from '../services/ApiService';

export default function LoginScreen({ navigation, onLogin }) {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [loading, setLoading] = useState(false);

  async function handleLogin() {
    if (!email || !password) { Alert.alert('Error', 'Completa todos los campos.'); return; }
    setLoading(true);
    try {
      const resultado = await UsuarioService.crear({ email, password });
      onLogin(resultado.token || 'token-placeholder', resultado.usuario || { email });
      navigation.replace('Home');
    } catch (err) {
      Alert.alert('Error de inicio de sesion', err.message);
    } finally {
      setLoading(false);
    }
  }

  return (
    <View style={styles.container}>
      <Text style={styles.titulo}>GameStore</Text>
      <Text style={styles.subtitulo}>Tu tienda de coleccionables</Text>
      <TextInput style={styles.input} placeholder="Email" placeholderTextColor="#666"
        value={email} onChangeText={setEmail} keyboardType="email-address" autoCapitalize="none" />
      <TextInput style={styles.input} placeholder="Contrasena" placeholderTextColor="#666"
        value={password} onChangeText={setPassword} secureTextEntry />
      <TouchableOpacity style={styles.boton} onPress={handleLogin} disabled={loading}>
        {loading ? <ActivityIndicator color="#fff" /> : <Text style={styles.botonTexto}>Iniciar sesion</Text>}
      </TouchableOpacity>
    </View>
  );
}

const styles = StyleSheet.create({
  container:  { flex: 1, backgroundColor: '#1a1a2e', justifyContent: 'center', paddingHorizontal: 30 },
  titulo:     { fontSize: 36, fontWeight: 'bold', color: '#e94560', textAlign: 'center', marginBottom: 8 },
  subtitulo:  { fontSize: 14, color: '#aaa', textAlign: 'center', marginBottom: 40 },
  input:      { backgroundColor: '#16213e', color: '#fff', borderRadius: 10, padding: 14, marginBottom: 16, borderWidth: 1, borderColor: '#e94560' },
  boton:      { backgroundColor: '#e94560', borderRadius: 10, padding: 16, alignItems: 'center' },
  botonTexto: { color: '#fff', fontWeight: 'bold', fontSize: 16 },
});
