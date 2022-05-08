module.exports ={
  
      resolve: {

        fallback: {
          // Here paste
          path: require.resolve("/home/alejandron/Documents/GitHub/Zemoga/zemoga-front/node_modules/axios-oauth-1.0a"),
          // But in mi case I paste
          crypto: require.resolve("/home/alejandron/Documents/GitHub/Zemoga/zemoga-front/node_modules/axios-oauth-1.0a"),
  
        }
      }
    }
  