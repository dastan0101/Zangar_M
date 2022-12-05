
var arrLang = {
    'en': {
        'home': 'Home',
        'about': 'About Us',
        'courses': 'Courses',
        'teacher': 'Teachers',
        'success': 'Our Successes',
        'contact': 'Contact',
        'boarding': 'Boarding school Zangar-M',
        'reach': 'Reach your goal with us',
        'best': 'Zangar-M is the best investment in education',
        'login': 'Login',
        'users': 'Users',

    },
    'ru': {
        'home': 'Главная',
        'about': 'О нас',
        'courses': 'Курсы',
        'teacher': 'Преподаватели',
        'success': 'Наши успехи',
        'contact': 'Контакт',
        'boarding': 'Школа-интернат Зангар-М',
        'reach': 'Достигните своей цели вместе с нами',
        'best': 'Зангар-М - лучшая инвестиция в образование',
        'login': 'Войти',
        'users': 'Пользователи',

    },
    'kz': {
        'home': 'Басты бет',
        'about': 'Біз туралы',
        'courses': 'Курстар',
        'teacher': 'Мұғалімдер',
        'success': 'Жетістіктер',
        'contact': 'Байланыс',
        'boarding': 'Заңғар-М мектеп-интернаты',
        'reach': 'Мақсатыңызға бізбен бірге жетіңіз',
        'best': 'Зангар-М-Білім берудегі ең жақсы инвестиция',
        'login': 'Кіру',
        'users': 'Пайдаланушылар'
    }
}

$(function () {
    $('.translate').click(function () {
        var lang = $(this).attr('id');

        $('.lang').each(function (index, item) {
            $(this).text(arrLang[lang][$(this).attr('key')]);
        })
    })
})