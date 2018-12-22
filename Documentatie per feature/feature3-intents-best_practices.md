# Feature 3: Intents en Best practices code cleanup

Vanaf de detail pagina willen we de meeting kunnen toevoegen aan onze kalender, een routebeschrijving krijgen en indien een website is meegegeven die website bekijken. Voor deze 3 dingen kan men gebruik maken van intents om andere applicaties de verwerking van deze aanvragen te laten doen.

Buiten intents is in deze feauture ook een pak code cleanp gedaan. In het bijzonder is er een Gui Viewmodel bijgemaakt die via modelbinding de actionbar instelt en zorgt voor een betere navigaties. Alle listeners worden ook aangemaakt in onstart ipv oncreate en gedisposed bij onstop. Enkele andere kleine aanpassingen werden rondom ook gedaan.
