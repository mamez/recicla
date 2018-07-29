export const navItems = [
  {
    title: true,
    name: 'Menú principal'
  },
  {
    name: 'Usuarios',
    url: '/usuarios',
    icon: 'icon-people'
  },
  {
    name: 'Puntos Críticos',
    url: '/puntos/criticos',
    icon: 'icon-location-pin'
  },
  {
      name: 'Puntos Recolección',
      url: '/puntos',
      icon: 'icon-location-pin',
      children: [
        {
          name: 'Usuarios',
          url: '/puntos/rec-publicos',
          icon: 'icon-trash'
        },
        {
          name: 'Publicos',
          url: '/puntos/rec-usuarios',
          icon: 'icon-trash'
        }
      ]
    },
    {
      name: 'Solicitudes',
      url: '/solicitud',
      icon: 'icon-paper-plane',
      children: [
        {
          name: 'Canjes',
          url: '/solicitud/canje',
          icon: 'icon-refresh'
        },
        {
          name: 'Recoleccion',
          url: '/solicitud/recoleccion',
          icon: 'icon-basket'
        }
      ]
    },
    {
        name: 'Parametrias',
        url: '/parametria',
        icon: 'icon-doc',
        children: [
          {
            name: 'Promociones',
            url: '/parametria/promociones',
            icon: 'icon-puzzle'
          },
          {
            name: 'Tipos Reciclajes',
            url: '/parametria/tipos-reciclaje',
            icon: 'icon-puzzle'
          }
        ]
      },
    {
      name: 'Tips',
      url: '/parametria/tips',
      icon: ' icon-info'
    }
];
