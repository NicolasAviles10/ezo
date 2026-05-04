// App.js — Punto de entrada de la app React Native
// Para instalar dependencias de navegación:
//   npm install @react-navigation/native @react-navigation/native-stack
//   npm install react-native-screens react-native-safe-area-context

import React, { useState } from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';

import LoginScreen       from './screens/LoginScreen';
import HomeScreen        from './screens/HomeScreen';
import ArticulosScreen   from './screens/ArticulosScreen';
import IntercambioScreen from './screens/IntercambioScreen';

const Stack = createNativeStackNavigator();

export default function App() {
  const [token, setToken] = useState(null);
  const [usuario, setUsuario] = useState(null);

  function onLogin(tok, user) {
    setToken(tok);
    setUsuario(user);
  }

  return (
    <NavigationContainer>
      <Stack.Navigator
        initialRouteName="Login"
        screenOptions={{
          headerStyle: { backgroundColor: '#1a1a2e' },
          headerTintColor: '#e94560',
          headerTitleStyle: { fontWeight: 'bold' },
        }}
      >
        <Stack.Screen name="Login" options={{ title: 'GameStore — Iniciar sesión' }}>
          {(props) => <LoginScreen {...props} onLogin={onLogin} />}
        </Stack.Screen>

        <Stack.Screen name="Home" options={{ title: 'GameStore' }}>
          {(props) => <HomeScreen {...props} usuario={usuario} token={token} />}
        </Stack.Screen>

        <Stack.Screen
          name="Articulos"
          component={ArticulosScreen}
          options={{ title: 'Artículos' }}
        />

        <Stack.Screen name="Intercambio" options={{ title: 'Mis Intercambios' }}>
          {(props) => <IntercambioScreen {...props} usuario={usuario} token={token} />}
        </Stack.Screen>
      </Stack.Navigator>
    </NavigationContainer>
  );
}
